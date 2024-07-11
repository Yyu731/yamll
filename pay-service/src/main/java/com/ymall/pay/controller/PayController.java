package com.ymall.pay.controller;


import com.ymall.api.domain.dto.PayApplyDTO;
import com.ymall.api.domain.dto.PayOrderFormDTO;
import com.ymall.common.exception.BizIllegalException;
import com.ymall.common.utils.BeanUtils;
import com.ymall.pay.domain.vo.PayOrderVO;
import com.ymall.pay.enums.PayType;
import com.ymall.pay.service.IPayOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "支付相关接口")
@RestController
@RequestMapping("pay-orders")
@RequiredArgsConstructor
public class PayController {

    private final IPayOrderService payOrderService;

    @Operation(summary = "查询支付单")
    @GetMapping
    public List<PayOrderVO> queryPayOrders() {
        return BeanUtils.copyList(payOrderService.list(), PayOrderVO.class);
    }

    @Operation(summary = "生成支付单")
    @PostMapping
    public Long applyPayOrder(@RequestBody PayApplyDTO applyDTO) {
        if (!PayType.BALANCE.equalsValue(applyDTO.getPayType())) {
            // 目前只支持余额支付
            throw new BizIllegalException("抱歉，目前只支持余额支付");
        }
        return payOrderService.applyPayOrder(applyDTO);
    }

    @Operation(summary = "尝试基于用户余额支付")
    @PostMapping("{id}")
    public void tryPayOrderByBalance(@Parameter(name = "支付单id") @PathVariable("id") Long id, @RequestBody PayOrderFormDTO payOrderFormDTO) {
        payOrderFormDTO.setId(id);
        payOrderService.tryPayOrderByBalance(payOrderFormDTO);
    }
}
