package com.ymall.user.controller;


import com.ymall.api.domain.dto.LoginFormDTO;
import com.ymall.common.domain.R;
import com.ymall.user.domain.vo.UserLoginVO;
import com.ymall.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户相关接口")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @Operation(summary = "用户登录接口")
    @PostMapping("login")
    public R login(@RequestBody @Validated LoginFormDTO loginFormDTO){
        return R.ok(userService.login(loginFormDTO));
    }

    @Operation(summary = "扣减余额")
    @PutMapping("/money/deduct")
    public void deductMoney(@Parameter(name = "支付密码") @RequestParam("pw") String pw, @Parameter(name = "支付金额") @RequestParam("amount") Integer amount){
        userService.deductMoney(pw, amount);
    }
}

