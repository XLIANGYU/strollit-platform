/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.exception;

/***
 * Web Exception, 区别于ApiException. 继承RuntimeException, 可无须在代码中显示处理.(一般预知外的异常允许全局异常兜底)
 *
 * @author icefrog.su@qq.com
 */
public class WebException extends RuntimeException {
    
    private static final long serialVersionUID = 3019594883245095604L;
    
    public WebException(){
        super();
    }
    
    public WebException(String message){
        super(message);
    }
    
    public WebException(String message, Throwable t){
        super(message, t);
    }
}
