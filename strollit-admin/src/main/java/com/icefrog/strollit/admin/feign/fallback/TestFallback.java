
package com.icefrog.strollit.admin.feign.fallback;

import com.icefrog.strollit.admin.feign.TestFeign;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.feign.BaseFallback;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestFallback extends BaseFallback implements FallbackFactory<TestFeign> {
    
    @Override
    public TestFeign create(Throwable throwable) {
        log.error("fallback ~~~~~~~~~~~" , throwable);
        return new TestFeign() {
            @Override
            public ApiResult aa() {
                throwable.printStackTrace();
                return error("fallback [a] message");
            }
    
            @Override
            public ApiResult bb() {
                throwable.printStackTrace();
                return error("fallback [b] message");
            }
        };
    }
}