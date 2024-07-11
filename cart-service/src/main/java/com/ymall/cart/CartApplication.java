package com.ymall.cart;

import com.ymall.api.client.ItemClient;
import com.ymall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: CartApplication
 * Package: com.ymall.cart
 * Description:
 *
 * @Author yy
 * @Create 2024-07-04 17:53
 * @Version 1.0
 */
@MapperScan("com.ymall.cart.mapper")
@EnableFeignClients(basePackageClasses = {ItemClient.class})
@SpringBootApplication
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
