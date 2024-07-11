package com.ymall.trade;

import com.ymall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: TradeApplication
 * Package: com.ymall.trade
 * Description:
 *
 * @Author yy
 * @Create 2024-07-05 20:06
 * @Version 1.0
 */
@EnableFeignClients(basePackages = "com.ymall.api.client")
@MapperScan("com.ymall.trade.mapper")
@SpringBootApplication
public class TradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeApplication.class, args);
    }
}