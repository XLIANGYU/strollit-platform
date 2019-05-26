/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.api;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.user.dto.UserDto;
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
    
}
