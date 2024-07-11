package com.ymall.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymall.api.domain.dto.ItemDTO;
import com.ymall.api.domain.dto.OrderDetailDTO;
import com.ymall.item.domain.po.Item;

import java.util.Collection;
import java.util.List;

public interface IItemService extends IService<Item> {

    void deductStock(List<OrderDetailDTO> items);

    List<ItemDTO> queryItemByIds(Collection<Long> ids);
}
