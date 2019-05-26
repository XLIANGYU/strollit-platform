/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.event;

import com.icefrog.strollit.admin.service.RoleService;
import com.icefrog.strollit.admin.service.UserService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.constance.PermissionConstance;
import com.icefrog.strollit.baseframework.event.IEvent;
import com.icefrog.strollit.baseframework.util.PasswdUtils;
import com.icefrog.strollit.user.dto.RoleDto;
import com.icefrog.strollit.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * 初始化系统权限信息, 包括内置角色, 超级管理员等信息
 * 依赖远程服务 (user-service-api)
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
@Slf4j
@Order(1000)
@Component
public class PermissionInitEvent implements IEvent, ApplicationRunner {

    @Value("${zoohub.devmode:false}")
    private boolean devMode;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    /*** 待初始化的角色信息集合 */
    private List<RoleDto> roles = new ArrayList<>();
    
    /*** 待初始化的用户信息结合 */
    private List<UserDto> users = new ArrayList<>();
    
    /***
     * Event's initialize
     * @return Object resource
     */
    @Override
    public Object init() {
        log.info("初始化系统权限相关资源...");
        
        // 初始化待执行的内置角色信息
        this.roles.add(this.buildRole(PermissionConstance.INTERNALLY_ADMIN_ROLE_ID, PermissionConstance.INTERNALLY_USER_ID,
            "管理员", "系统内置角色"));
        this.roles.add(this.buildRole(PermissionConstance.INTERNALLY_STORE_ROLE_ID, PermissionConstance.INTERNALLY_USER_ID,
            "门店店长", "系统内置角色"));
        this.roles.add(this.buildRole(PermissionConstance.INTERNALLY_USER_ROLE_ID, PermissionConstance.INTERNALLY_USER_ID,
            "普通用户", "系统内置角色"));
        
        // 初始化待执行的内置用户信息
        this.users.add(this.buildUser(PermissionConstance.INTERNALLY_USER_ID, PermissionConstance.INTERNALLY_ADMIN_ROLE_ID,
            "admin", "Administrator", "123456"));
        
        return null;
    }
    
    /***
     * Event's destroy
     */
    @Override
    public void destroy() {
        // help gc
        this.roles = null;
        this.users = null;
        
        log.info("资源释放成功");
    }
    
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!devMode) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
    
            try {
                this.init();
        
                this.security(this.initCreateRoles());
        
                this.security(this.initCreateUsers());
        
                this.destroy();
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                this.security(false);
            }
    
            stopWatch.stop();
            log.info("累计耗时: {}", stopWatch.getTotalTimeSeconds());
        }
    }
    
    // 创建角色信息
    private boolean initCreateRoles(){
        ApiResult<Integer> insertCountResult = roleService.batchInsertRole(this.roles);
        if(insertCountResult == null || insertCountResult.isError()) {
            return false;
        }
        log.info("成功初始化内置角色信息[{}]条", insertCountResult.getData());
        return true;
    }
    
    // 创建用户信息
    private boolean initCreateUsers(){
        ApiResult<Integer> insertCountResult = userService.batchInsertUser(this.users);
        if(insertCountResult == null || insertCountResult.isError()) {
            return false;
        }
        log.info("成功初始化内置用户信息[{}]条", insertCountResult.getData());
        return true;
    }
    
    private final void security(boolean exit) {
        if(!exit){
            log.error("初始化权限资源失败, 终止服务启动!");
            System.exit(-1);
        }
    }
    
    
    // 构建内置角色Dto
    private RoleDto buildRole(String roleId, String userId, String roleName, String remark){
        RoleDto role = new RoleDto();
        role.setId(roleId);
        role.setUpdateId(userId);
        role.setCreateId(userId);
        role.setRoleName(roleName);
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        role.setRemark(remark);
        role.setIsDel(0);
        return role;
    }
    
    // 构建内置用户Dto
    private UserDto buildUser(String userId, String roleId, String account, String nickName, String passwd) {
        String salt = String.valueOf(System.currentTimeMillis());
        UserDto user = new UserDto();
        user.setId(userId);
        user.setRoleId(roleId);
        user.setProvindeId(null);
        user.setCityId(null);
        user.setCountyId(null);
        user.setTownId(null);
        user.setAccount(account);
        user.setNickName(nickName);
        user.setPasswd(PasswdUtils.buildPasswd(passwd, salt));
        user.setSalt(salt);
        user.setIsDestory(0);
        user.setIsDisable(0);
        user.setIsDel(0);
        return user;
    }
}
