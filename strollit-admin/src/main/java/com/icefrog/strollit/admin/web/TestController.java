/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.web;

import com.icefrog.strollit.admin.feign.TestFeign;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.WebBaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
@Slf4j
public class TestController extends WebBaseController {

    @Autowired
    private TestFeign testFeign;
    
    @RequestMapping("/go")
    @ResponseBody
    public String go() throws Exception {
        System.out.println("进入go");
        // 测试远程调用（依赖community服务）
        ApiResult aa = testFeign.aa();
        ApiResult bb = testFeign.bb();
        System.out.println(aa.getMessage());
        System.out.println(bb.getMessage());
        return "success";
    }
    
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(){
        // 测试Thymeleaf模板引擎
        getRequest().setAttribute("desc", "this is desc");
        log.info("in testThymeleaf action.");
        return "template";
    }


}
