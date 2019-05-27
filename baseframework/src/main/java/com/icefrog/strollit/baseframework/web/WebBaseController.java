/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.exception.WebException;

/***
 * WebBaseController, 为基础web提供服务. 区别于ApiBaseController
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public abstract class WebBaseController extends BaseController {
    /***
     * 引发ApiException
     * WebBaseController 不支持此方法, 调用此方法将引发UnsupportedOperationException异常
     * 请参见ApiBaseController
     * @param message exception message
     * @throws Exception Exception
     */
    @Deprecated
    @Override
    public void throwApiException(String message) throws Exception {
        throw new UnsupportedOperationException("WebBaseController Unsupported the ApiException, please see the ApiBaseController");
    }
    
    /***
     * 引发ApiException
     * WebBaseController 不支持此方法, 调用此方法将引发UnsupportedOperationException异常
     * 请参见ApiBaseController
     * @param message exception message
     * @param t Throwable
     * @throws Exception Exception
     */
    @Deprecated
    @Override
    public void throwApiException(String message, Throwable t) throws Exception {
        throw new UnsupportedOperationException("WebBaseController Unsupported the ApiException, please see the ApiBaseController");
    }
    
    /***
     * 引发WebException (extends to RuntimeException)
     */
    @Override
    public void throwWebException() {
        throw new WebException();
    }
    
    /***
     * 引发WebException (extends to RuntimeException)
     * @param message exception message
     */
    @Override
    public void throwWebException(String message) {
        throw new WebException(message);
    }
    
    /***
     * 引发WebException (extends to RuntimeException)
     * @param message exception message
     * @param t Throwable
     */
    @Override
    public void throwWebException(String message, Throwable t) {
        throw new WebException(message, t);
    }
}
