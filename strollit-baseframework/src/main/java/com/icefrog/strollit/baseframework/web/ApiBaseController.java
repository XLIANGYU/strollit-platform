/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.exception.ApiException;

import java.util.Map;

/***
 * ApiBaseController, 为Rest服务提供基础能力. 区别于WebBaseController
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public abstract class ApiBaseController extends BaseController {
    
    /***
     * 构建一个默认消息的成功状态返回对象
     * @return ApiResult
     */
    protected ApiResult success(){
        return this.buildApiResult(ApiResult.CODE_SUCCESS, ApiResult.SUCCESS_MESSAGE, null);
    }
    
    /***
     * 构建一个返回指定消息的成功状态返回对象
     * @param message 成功消息
     * @return ApiResult
     */
    protected ApiResult success(String message){
        return this.buildApiResult(ApiResult.CODE_SUCCESS, message, null);
    }
    
    /***
     * 构建一个返回指定消息和附加数据的成功状态返回对象
     * @param message 成功消息
     * @param data 附加数据
     * @return ApiResult
     */
    protected ApiResult success(String message, Map<String, Object> data){
        return this.buildApiResult(ApiResult.CODE_SUCCESS, message, data);
    }
    
    /***
     * 构建一个默认消息的失败状态返回对象
     * @return ApiResult
     */
    protected ApiResult error(){
        return this.buildApiResult(ApiResult.CODE_FAILED, ApiResult.FAILED_MESSAGE, null);
    }
    
    /***
     * 构建一个返回指定消息的失败状态返回对象
     * @param message 失败消息
     * @return ApiResult
     */
    protected ApiResult error(String message){
        return this.buildApiResult(ApiResult.CODE_FAILED, message, null);
    }
    
    /***
     * 构建一个返回指定消息和附加数据的失败状态返回对象
     * @param message 失败消息
     * @param data 附加数据
     * @return ApiResult
     */
    protected ApiResult error(String message, Map<String, Object> data){
        return this.buildApiResult(ApiResult.CODE_FAILED, message, data);
    }
    
    private ApiResult buildApiResult(final int code, final String message, Map data){
        return new ApiResult().setCode(code).setMessage(message).setData(data);
    }
    
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
    @Override
    public void throwWebException(String message, Throwable t) {
        throw new UnsupportedOperationException("ApiBaseController Unsupported the WebException, please see the WebBaseController");
    }
    
}
