package com.ymall.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.ymall.common.utils.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: UserInfoIntercepter
 * Package: com.ymall.common.interceptor
 * Description:
 *
 * @Author yy
 * @Create 2024-07-04 21:04
 * @Version 1.0
 */
public class UserInfoIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userInfo  = request.getHeader("user-info");
        if (StrUtil.isNotBlank(userInfo)) {
            UserContext.setUser(Long.valueOf(userInfo));
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.removeUser();
    }
}
