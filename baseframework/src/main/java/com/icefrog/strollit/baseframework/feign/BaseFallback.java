/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.feign;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.BaseServer;
import lombok.extern.slf4j.Slf4j;

/***
 * 基础Fallback
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
@Slf4j
public abstract class BaseFallback extends BaseServer {
    
    protected ApiResult errorHandler(String message ,Throwable t){
        log.error(message, t.getMessage(), t);
        return error(message + t.getMessage());
    }

}