package com.ymall.cart.controller;


import com.ymall.api.domain.dto.CartFormDTO;
import com.ymall.cart.domain.po.Cart;
import com.ymall.cart.domain.vo.CartVO;
import com.ymall.cart.service.ICartService;
import com.ymall.common.domain.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="购物车相关接口")
@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @Operation(summary = "添加商品到购物车")
    @PostMapping
    public R<Void> addItem2Cart(@Valid @RequestBody CartFormDTO cartFormDTO){
        cartService.addItem2Cart(cartFormDTO);
        return R.ok();
    }

    @Operation(summary = "更新购物车数据")
    @PutMapping
    public void updateCart(@RequestBody Cart cart){
        cartService.updateById(cart);
    }

    @Operation(summary = "删除购物车中商品")
    @DeleteMapping("{id}")
    public void deleteCartItem(@Param ("购物车条目id")@PathVariable("id") Long id){
        cartService.removeById(id);
    }

    @Operation(summary = "查询购物车列表")
    @GetMapping
    public R<List<CartVO>> queryMyCarts(){
        return R.ok(cartService.queryMyCarts());
    }

    @Operation(summary = "查询购物车数量")
    @GetMapping("/count/{id}")
    public R<Long> queryMyCartsCount(@PathVariable Long id){
        return R.ok(cartService.queryMyCartsCount(id));
    }

    @Operation(summary = "批量删除购物车中商品")
    @DeleteMapping
    public void deleteCartItemByIds(@Parameter(name = "购物车条目id集合") @RequestParam("ids") List<Long> ids){
        cartService.removeByItemIds(ids);
    }
}
