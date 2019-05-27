/*
 * Copyright 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client;

import com.icefrog.strollit.admin.client.fallback.UserFeignClientFallback;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.microserver.ServiceId;
import com.icefrog.strollit.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value= ServiceId.USER_SERVICE, fallbackFactory = UserFeignClientFallback.class)
public interface UserFeignClient {
    
    @RequestMapping("/api/user/batchInsertUser")
    ApiResult<Integer> batchInsertUser(@RequestBody List<UserDto> userDtos);
    
    /***
     * 使用account账户信息检索一个用户(仅排除逻辑删除)
     * @param account 登录账户
     * @return ApiResult<UserDto>
     */
    @RequestMapping("/api/user/loginWithQueryUser")
    ApiResult<UserDto> loginWithQueryUser(@RequestParam(name = "account") String account);
    
    /***
     * 分页查询用户列表
     * @param account 登录账户（模糊查询）
     * @param nickName 昵称（模糊查询）
     * @param roleId 角色编号
     * @param pageIndex page index
     * @param pageSize page size
     * @return ApiResult<List<TbUser>>
     */
    @RequestMapping("/api/user/pageQueryUserList")
    ApiResult<List<UserDto>> pageQueryUserList(@RequestParam(name = "account", required = false) String account,
                                              @RequestParam(name = "nickName", required = false) String nickName,
                                              @RequestParam(name = "roleId", required = false) String roleId,
                                              @RequestParam(name = "pageIndex") Integer pageIndex,
                                              @RequestParam(name = "pageSize") Integer pageSize);
    
    /***
     * 通过ID查询一个用户信息
     * @param userId 用户ID
     * @return ApiResult<UserDto>
     */
    @RequestMapping("/api/user/queryUserDetailById")
    ApiResult<UserDto> queryUserDetailById(@RequestParam(name = "userId", required = false) String userId);
    
    /***
     * 修改一个用户信息
     * @param userDto UserDto obj
     * @return ApiResult
     */
    @RequestMapping("/api/user/updateUser")
    ApiResult updateUser(@RequestBody UserDto userDto);
    
    /***
     * 批量逻辑删除用户信息
     * @param userIds
     * @return ApiResult
     */
    @RequestMapping("/api/user/batchRemoveUser")
    ApiResult batchRemoveUser(@RequestBody List<String> userIds);
    
    /***
     * 保存一个用户信息
     * @param userDto UserDto obj
     * @return ApiResult
     */
    @RequestMapping("/api/user/saveUser")
    ApiResult saveUser(@RequestBody UserDto userDto);
}
