package com.ymall.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymall.api.domain.dto.PayApplyDTO;
import com.ymall.api.domain.dto.PayOrderFormDTO;
import com.ymall.pay.domain.po.PayOrder;

public interface IPayOrderService extends IService<PayOrder> {

    Long applyPayOrder(PayApplyDTO applyDTO);

    void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO);
}
