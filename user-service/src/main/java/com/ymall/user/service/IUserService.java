package com.ymall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymall.api.domain.dto.LoginFormDTO;
import com.ymall.user.domain.po.User;
import com.ymall.user.domain.vo.UserLoginVO;

public interface IUserService extends IService<User> {

    UserLoginVO login(LoginFormDTO loginFormDTO);

    void deductMoney(String pw, Integer totalFee);
}
