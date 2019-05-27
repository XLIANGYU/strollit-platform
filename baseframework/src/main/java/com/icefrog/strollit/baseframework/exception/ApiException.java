/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.exception;

/***
 * Api Exception.  用于在任何形式的rest调用中。 不提供无参构造器， 因为所有ApiException都应当具备一个可直接提示用户的异常信息
 *
 * 继承Exception, 用于警示web层尽量手动处理异常兜底, 而非全局异常处理
 *
 * @author icefrog.su@qq.com
 */
public class ApiException extends Exception {
    
    private static final long serialVersionUID = 1218182282183079791L;
    
    public ApiException(String message){
        super(message);
    }
    
    public ApiException(String message, Throwable t){
        super(message, t);
    }
    
    
}
