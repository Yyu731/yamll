package com.ymall.api.config;

import com.ymall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DefaultFeignConfig
 * Package: com.ymall.api.config
 * Description:
 *
 * @Author yy
 * @Create 2024-07-04 20:08
 * @Version 1.0
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor userInfoRequestInterceptor() {
        return template -> {
            Long userInfo = UserContext.getUser();
            if (userInfo != null) {
                template.header("user-info", String.valueOf(userInfo));
            }
        };
    }
}
