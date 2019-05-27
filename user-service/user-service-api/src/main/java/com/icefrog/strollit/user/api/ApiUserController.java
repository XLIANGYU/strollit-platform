/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.api;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.user.dto.UserDto;
import com.icefrog.strollit.user.model.TbUser;
import com.icefrog.strollit.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * 用户相关接口
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {
    
    @Autowired
    private UserService userService;
    
    /***
     * 批量保存用户信息, 当用户存在（ID）且未逻辑删除则忽略保存该数据. 具体保存成功的数量
     * 取决于ApiResult<Integer>指定内容
     * @param userDtos user dto list
     * @return ApiResult<Integer>
     */
    @RequestMapping("/batchInsertUser")
    public ApiResult<Integer> batchInsertUser(@RequestBody List<UserDto> userDtos) {
        return userService.batchInsertUser(userDtos);
    }
    
    /***
     * 使用account账户信息检索一个用户(仅排除逻辑删除)
     * @param account 登录账户
     * @return ApiResult<UserDto>
     */
    @RequestMapping("loginWithQueryUser")
    public ApiResult<UserDto> loginWithQueryUser(@RequestParam(name = "account") String account){
        return userService.loginWithQueryUser(account);
    }
    
    /***
     * 分页查询用户列表
     * @param account 登录账户（模糊查询）
     * @param nickName 昵称（模糊查询）
     * @param roleId 角色编号
     * @param pageIndex page index
     * @param pageSize page size
     * @return ApiResult<List<TbUser>>
     */
    @RequestMapping("/pageQueryUserList")
    public ApiResult<List<TbUser>> pageQueryUserList(@RequestParam(name = "account", required = false) String account,
                                              @RequestParam(name = "nickName", required = false) String nickName,
                                              @RequestParam(name = "roleId", required = false) String roleId,
                                              @RequestParam(name = "pageIndex") Integer pageIndex,
                                              @RequestParam(name = "pageSize") Integer pageSize) {
        return userService.pageQueryUserList(account, nickName, roleId, pageIndex, pageSize);
    }
    
    /***
     * 通过ID查询一个用户信息
     * @param userId 用户ID
     * @return ApiResult<UserDto>
     */
    @RequestMapping("/queryUserDetailById")
    public ApiResult<UserDto> queryUserDetailById(@RequestParam(name = "userId", required = false) String userId) {
        return userService.queryUserDetail(userId);
    }
    
    /***
     * 修改一个用户信息
     * @param userDto UserDto obj
     * @return ApiResult
     */
    @RequestMapping("/updateUser")
    public ApiResult updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }
    
    /***
     * 批量逻辑删除用户信息
     * @param userIds
     * @return ApiResult
     */
    @RequestMapping("/batchRemoveUser")
    public ApiResult batchRemoveUser(@RequestBody List<String> userIds){
        return userService.batchRemoveUser(userIds);
    }
    
    /***
     * 保存一个用户信息
     * @param userDto UserDto obj
     * @return ApiResult
     */
    @RequestMapping("/saveUser")
    public ApiResult saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
    
}
