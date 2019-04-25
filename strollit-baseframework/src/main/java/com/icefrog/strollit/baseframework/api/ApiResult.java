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
 *
 * @version 1.2 添加CODE_UNLOGINED=99标识未登录情况的ajax响应
 * 				添加CODE_UNTREATEDEXCEPTION=100标识未处理异常
 */
public class ApiResult implements Serializable {
	private static final long serialVersionUID 			= -6486606756679486803L;
	public static final Integer CODE_SUCCESS        	= 0;  // 响应成功
	public static final Integer CODE_FAILED         	= 1;  // 响应失败
	public static final Integer CODE_INVALID        	= 2;
	public static final Integer CODE_FEIGN_ERROR    	= 9;  // 响应feign调用失败
	public static final Integer CODE_UNLOGINED      	= 99; // 响应未登录
	public static final Integer CODE_UNTREATEDEXCEPTION = 100;// 响应未处理异常
	public static final String  DEFAULT_FUNCTIONID  	= "default_function_id";
	public static final String  SUCCESS_MESSAGE     	= "success";
	public static final String  FAILED_MESSAGE      	= "failed";
	
	private String functionId;
	
	private String message;
	
	private Integer code;
	
	private Map<String, Object> data = new ConcurrentHashMap<>();

	
	public String getFunctionId() {
		return functionId;
	}

	public ApiResult setFunctionId(String functionId) {
		this.functionId = functionId;
		return this;
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

	public Map<String, Object> getData() {
		return data;
	}

	public ApiResult setData(Map<String, Object> data) {
		this.data = data;
		return this;
	}
	
	public Map<String, Object> putDate(String key,Object val){
		this.data.put(key, val);
		return this.data;
	}
}