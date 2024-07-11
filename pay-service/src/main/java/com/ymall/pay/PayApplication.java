package com.ymall.pay;

import com.ymall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: PayApplication
 * Package: com.ymall.pay
 * Description:
 *
 * @Author yy
 * @Create 2024-07-05 20:32
 * @Version 1.0
 */
@EnableFeignClients(basePackages = "com.ymall.api.client")
@MapperScan("com.ymall.pay.mapper")
@SpringBootApplication
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
