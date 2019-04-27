package com.icefrog.strollit.admin.feign;

import com.icefrog.strollit.admin.feign.fallback.TestFallback;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.microserver.ServiceId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(serviceId = ServiceId.STORLLIT_COMMUNITY, fallbackFactory = TestFallback.class)
public interface TestFeign {
    
    @RequestMapping("/comm/aa")
    ApiResult aa();
    
    @RequestMapping("/comm/bb")
    ApiResult bb();
    
}