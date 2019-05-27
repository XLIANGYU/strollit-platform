/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.util;

import com.icefrog.strollit.baseframework.api.ApiResult;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Slf4j
public class RspUtils {

    public static void responseErrorApiResultJson(final String message, Map<String, Object> data, HttpServletResponse response){
        responseApiResultJson(ApiResult.CODE_FAILED, message, data, response);
    }
    
    public static void responseApiResultJson(final int code, final String message, final Map<String, Object> data,
                                      HttpServletResponse response){
        PrintWriter out = null;
        ApiResult apiResult = new ApiResult().setCode(code).setMessage(message).setData(data);
        String jsonApiResult = JSONObject.fromObject(apiResult).toString();
        try{
            response.setContentType("application/json;charset=UTF-8");
            out = response.getWriter();
            out.write(jsonApiResult);
        } catch (Exception e){
            log.error("response error (RspUtils#responseApiResultJson)", e);
        } finally {
            if(out != null){
                out.close();
            }
        }
    }

}