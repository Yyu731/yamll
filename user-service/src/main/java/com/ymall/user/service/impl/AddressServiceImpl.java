package com.ymall.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymall.user.domain.po.Address;
import com.ymall.user.mapper.AddressMapper;
import com.ymall.user.service.IAddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
