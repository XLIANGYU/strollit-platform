/*
 * Copyright 2018 www.zoomgo.net Co., Ltd 版权所有
 *
 * author: icefrog.su@qq.com
 *
 */

package com.icefrog.strollit.baseframework.api;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * ApiResult. http response object
 *
 * @author icefrog.su@qq.com
 */
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -3624770785365476720L;
    
	public static final Integer CODE_SUCCESS        	= 0;  // 响应成功
	public static final Integer CODE_FAILED         	= 1;  // 响应失败
	public static final String  SUCCESS_MESSAGE     	= "success";
	public static final String  FAILED_MESSAGE      	= "failed";
    
    private String message;
	
	private Integer code;
	
	private T data;
    
    /***
     * 构建一个描述正确状态的ApiResult(code=ApiResult.CODE_SUCCESS)
     * 并指定需要返回的数据对象
     * message字段为默认值(message=ApiResult.SUCCESS_MESSAGE)
     * @param data 需要返回的数据对象
     * @return ApiResult object with success status
     */
	public ApiResult success(T data){
        return new ApiResult<T>().setCode(ApiResult.CODE_SUCCESS).setMessage(ApiResult.SUCCESS_MESSAGE).setData(data);
    }
    
    /***
     * 构建一个描述正确状态的ApiResult(code=ApiResult.CODE_SUCCESS)
     * 并指定需要返回的数据对象
     * @param data 需要返回的数据对象
     * @param message 自定义消息
     * @return ApiResult object with success status
     */
    public ApiResult success(String message, T data){
        return new ApiResult<T>().setCode(ApiResult.CODE_SUCCESS).setMessage(message).setData(data);
    }
    
    /***
     * 构建一个描述错误在的ApiResult(code=ApiResult.CODE_FAILED)
     * 并指定需要返回的数据对象
     * @param data 需要返回的数据对象
     * @return ApiResult object with error status
     */
    public ApiResult error(T data){
        return new ApiResult<T>().setCode(ApiResult.CODE_FAILED).setMessage(ApiResult.FAILED_MESSAGE).setData(data);
    }
    
    /***
     * 构建一个描述错误在的ApiResult(code=ApiResult.CODE_FAILED)
     * 并指定需要返回的数据对象
     * @param message 自定义消息
     * @param data 需要返回的数据对象
     * @return ApiResult object with error status
     */
    public ApiResult error(String message, T data){
        return new ApiResult<T>().setCode(ApiResult.CODE_FAILED).setMessage(message).setData(data);
    }
	

	public String getMessage() {
		return message;
	}

	public ApiResult setMessage(String message) {
		this.message = message;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public ApiResult setCode(Integer code) {
		this.code = code;
		return this;
	}

	public T getData() {
		return data;
	}

	public ApiResult setData(T data) {
		this.data = data;
		return this;
	}
}