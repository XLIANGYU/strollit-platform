/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.exception.ApiException;

/***
 * ApiBaseController, 为Rest服务提供基础能力. 区别于WebBaseController
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public abstract class ApiBaseController extends BaseController {
    
    /***
     * 引发ApiException
     * @param message exception message
     * @throws Exception Exception
     */
    @Override
    public void throwApiException(String message) throws Exception {
        throw new ApiException(message);
    }
    
    /***
     * 引发ApiException
     * @param message exception message
     * @param t Throwable
     * @throws Exception Exception
     */
    @Override
    public void throwApiException(String message, Throwable t) throws Exception {
        throw new ApiException(message, t);
    }
    
    /***
     * 引发WebException (extends to RuntimeException)
     * ApiBaseController 不支持此方法, 调用此方法将引发UnsupportedOperationException异常
     * 请参见WebBaseController
     */
    @Deprecated
    @Override
    public void throwWebException() {
        throw new UnsupportedOperationException("ApiBaseController Unsupported the WebException, please see the WebBaseController");
    }
    
    /***
     * 引发WebException (extends to RuntimeException)
     * ApiBaseController 不支持此方法, 调用此方法将引发UnsupportedOperationException异常
     * 请参见WebBaseController
     * @param message exception message
     */
    @Deprecated
    @Override
    public void throwWebException(String message) {
        throw new UnsupportedOperationException("ApiBaseController Unsupported the WebException, please see the WebBaseController");
    }
    
    /***
     * 引发WebException (extends to RuntimeException)
     * ApiBaseController 不支持此方法, 调用此方法将引发UnsupportedOperationException异常
     * 请参见WebBaseController
     * @param message exception message
     * @param t Throwable
     */
    @Deprecated
    @Override
    public void throwWebException(String message, Throwable t) {
        throw new UnsupportedOperationException("ApiBaseController Unsupported the WebException, please see the WebBaseController");
    }
    
}
