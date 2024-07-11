package com.ymall.user;

import com.ymall.api.client.ItemClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName: UserApplication
 * Package: com.ymall.user
 * Description:
 *
 * @Author yy
 * @Create 2024-07-05 19:23
 * @Version 1.0
 */
@EnableFeignClients(basePackages = "com.ymall.api.client")
@MapperScan("com.ymall.user.mapper")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}