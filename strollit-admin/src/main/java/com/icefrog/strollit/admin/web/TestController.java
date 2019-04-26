/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.web;

import com.icefrog.strollit.baseframework.web.WebBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController extends WebBaseController {

    @RequestMapping("/go")
    public String go() throws Exception {
        System.out.println("进入go");
        throwWebException("test");
        return "";
    }


}
