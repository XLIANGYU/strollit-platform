package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.api.ApiResult;

import java.util.HashMap;
import java.util.Map;

/***
 * 基础service, 包含针对ApiResult的快捷操作
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public class BaseServer {
    
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
    
    protected ApiResult success(Map<String, Object> data){
        return this.success(ApiResult.SUCCESS_MESSAGE, data);
    }
    
    protected ApiResult success(String key, String value){
        Map<String, Object> data = new HashMap<>(1);
        data.put(key, value);
        return this.success(data);
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
    
}