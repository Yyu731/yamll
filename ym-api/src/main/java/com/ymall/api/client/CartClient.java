package com.ymall.api.client;

import com.ymall.api.config.DefaultFeignConfig;
import com.ymall.api.domain.dto.ItemDTO;
import com.ymall.api.domain.dto.OrderDetailDTO;
import com.ymall.common.domain.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "cart-service", configuration = DefaultFeignConfig.class)
public interface CartClient {

    @DeleteMapping("/carts")
    void deleteCartItemByIds(@Parameter(name = "购物车条目id集合") @RequestParam("ids") Collection<Long> ids);

    @GetMapping("/carts/count/{id}")
    R<Long> queryMyCartsCount(@PathVariable Long id);
}