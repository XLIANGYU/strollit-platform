/*
 * Copyright 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

/***
 * 基础Controller规约. 约束Controller基础操作限制
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public interface IController {
    
    /***
     * 引发ApiException
     * @param message exception message
     * @throws Exception Exception
     */
    void throwApiException(String message) throws Exception;
    
    /***
     * 引发ApiException
     * @param message exception message
     * @param t Throwable
     * @throws Exception Exception
     */
    void throwApiException(String message, Throwable t) throws Exception;
    
    /***
     * 引发WebException (extends to RuntimeException)
     */
    void throwWebException();
    
    /***
     * 引发WebException (extends to RuntimeException)
     * @param message exception message
     */
    void throwWebException(String message);
    
    /***
     * 引发WebException (extends to RuntimeException)
     * @param message exception message
     * @param t Throwable
     */
    void throwWebException(String message, Throwable t);
    
}
