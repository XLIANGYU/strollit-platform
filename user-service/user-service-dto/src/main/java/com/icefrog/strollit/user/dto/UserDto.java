/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.dto;

import lombok.Data;

@Data
public class UserDto {
    
    private String id;
    
    private String roleId;
    
    private String provindeId;
    
    private String cityId;
    
    private String countyId;
    
    private String townId;
    
    private String account;
    
    private String nickName;
    
    private String passwd;
    
    private String salt;
    
    private String faceUrl;
    
    private String wxToken;
    
    private String infoAddress;
    
    private String sex;
    
    private Integer isDestory;
    
    private Integer isDisable;
    
    private Integer isDel;
    
}
