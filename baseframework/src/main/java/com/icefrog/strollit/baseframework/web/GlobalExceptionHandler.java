/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.exception.ApiException;
import com.icefrog.strollit.baseframework.exception.WebException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * Global Exception Handler.  针对多种异常类型不同处理
 *
 * @author icefrog.su@qq.com
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ApiBaseController {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResult apiGlobalExceptionHandler(Exception e){
        String errorMsg = String.format("系统异常:%s", e.getMessage());
        log.error(errorMsg, e);
        return error(errorMsg);
    }
    
    @ExceptionHandler(WebException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String webGlobalExceptionHandler(Exception e){
        String errorMsg = String.format("系统异常:%s", e.getMessage());
        log.error(errorMsg, e);
        return "/error/500.html";
    }

}
