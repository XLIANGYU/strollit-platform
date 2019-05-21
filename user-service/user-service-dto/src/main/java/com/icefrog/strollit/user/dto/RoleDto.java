/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RoleDto implements Serializable {
    private static final long serialVersionUID = -8201575390059461739L;
    private String id;
    
    private String updateId;
    
    private String createId;
    
    private String roleName;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String remark;
    
    private Integer isDel;
    
}
