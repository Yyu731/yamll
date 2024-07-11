package com.ymall.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("yy商城项目API")
                        .version("1.0")
                        .description("yy商城项目的接口文档"));
    }
    
    @Bean
    public GroupedOpenApi itemAPI() {
        return GroupedOpenApi.builder().group("商品信息管理").
                pathsToMatch("/items/**").
                build();
    }

    @Bean
    public GroupedOpenApi cartAPI() {
        return GroupedOpenApi.builder().group("购物车管理").
                pathsToMatch("/carts/**").
                build();
    }

    @Bean
    public GroupedOpenApi userAPI() {
        return GroupedOpenApi.builder().group("用户管理").
                pathsToMatch("/users/**").
                build();
    }

    @Bean
    public GroupedOpenApi tradeAPI() {
        return GroupedOpenApi.builder().group("交易管理").
                pathsToMatch("/orders/**").
                build();
    }

    @Bean
    public GroupedOpenApi payAPI() {
        return GroupedOpenApi.builder().group("支付管理").
                pathsToMatch("/pay-orders/**").
                build();
    }
}