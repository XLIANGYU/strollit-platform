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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestController extends WebBaseController {

    @Autowired
    private TestFeign testFeign;
    
    @RequestMapping("/go")
    @ResponseBody
    public String go() throws Exception {
        System.out.println("进入go");
        ApiResult aa = testFeign.aa();
        ApiResult bb = testFeign.bb();
        System.out.println(aa.getMessage());
        System.out.println(bb.getMessage());
        return "success";
    }


}
