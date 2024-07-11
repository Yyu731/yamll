package com.ymall.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymall.api.domain.dto.CartFormDTO;
import com.ymall.cart.domain.po.Cart;
import com.ymall.cart.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

public interface ICartService extends IService<Cart> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);

    Long queryMyCartsCount(Long id);
}
