package com.icefrog.strollit.community.api;


import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.ApiBaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/comm")
@RestController
public class TestController extends ApiBaseController {
    
    @RequestMapping("/aa")
    public ApiResult aa(){
        return success("nice~ aa");
    }
    @RequestMapping("/bb")
    public ApiResult bb(){
        return success("nice~ bb");
    }
    
}