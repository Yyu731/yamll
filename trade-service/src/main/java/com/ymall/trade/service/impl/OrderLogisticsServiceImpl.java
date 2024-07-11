package com.ymall.trade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymall.trade.domain.po.OrderLogistics;
import com.ymall.trade.mapper.OrderLogisticsMapper;
import com.ymall.trade.service.IOrderLogisticsService;
import org.springframework.stereotype.Service;

@Service
public class OrderLogisticsServiceImpl extends ServiceImpl<OrderLogisticsMapper, OrderLogistics> implements IOrderLogisticsService {

}
