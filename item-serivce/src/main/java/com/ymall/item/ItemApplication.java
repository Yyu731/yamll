package com.ymall.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: ItemApplication
 * Package: com.yy.item
 * Description:
 *
 * @Author yy
 * @Create 2024-07-04 10:28
 * @Version 1.0
 */
@MapperScan("com.ymall.item.mapper")
@SpringBootApplication
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class, args);
    }
}
