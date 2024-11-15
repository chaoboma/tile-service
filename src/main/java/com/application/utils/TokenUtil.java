package com.application.utils;


import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：Mr.ZJW
 * @date ：Created 2022/2/28 10:24
 * @description：
 */
@Slf4j
public class TokenUtil {

    public static String getTokenUserId() {
        String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }
    public static String getToken() {
        String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
        return token;
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

}


