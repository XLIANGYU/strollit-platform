
package com.icefrog.strollit.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

    @RequestMapping("/index")
    public String toIndex(){
        return "home/index";
    }
    
    @RequestMapping("/toMainPage")
    public String toMainPage(){
        return "home/main";
    }

}