package com.ymall.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymall.api.domain.dto.OrderFormDTO;
import com.ymall.trade.domain.po.Order;

public interface IOrderService extends IService<Order> {

    Long createOrder(OrderFormDTO orderFormDTO);

    void markOrderPaySuccess(Long orderId);
}
