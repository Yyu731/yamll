package com.ymall.trade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymall.trade.domain.po.OrderDetail;
import com.ymall.trade.mapper.OrderDetailMapper;
import com.ymall.trade.service.IOrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
