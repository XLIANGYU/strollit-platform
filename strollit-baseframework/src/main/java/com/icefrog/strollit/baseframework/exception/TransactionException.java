/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.exception;

/***
 * Transaction Exception. 用于各种事务场景回滚（Spring注解事务需要RuntimeException或派生类作为回滚依据）
 *
 * @author icefrog.su@qq.com
 */
public class TransactionException extends RuntimeException {
    
    private static final long serialVersionUID = 5912317429431109021L;
    
    public TransactionException(){
        super();
    }
    
    public TransactionException(String message){
        super(message);
    }
    
    public TransactionException(String message, Throwable t){
        super(message, t);
    }
}
