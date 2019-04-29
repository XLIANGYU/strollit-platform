package com.icefrog.strollit.baseframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class UserDto implements Serializable {
    private static final long serialVersionUID = -8701821281114093146L;
    
    private String userId;
    
    private String token;
    
    private String account;
    
    private String nickName;

}