package com_xpu.common.Context;

import com_xpu.domain.entity.Users;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestContext {
    public static HttpServletRequest getCurrentRequest() {
        // 通过`RequestContextHolder`获取当前request请求对象
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }
    public static Users getCurrentUser() {
        // 通过request对象获取session对象，再获取当前用户对象
        return (Users)getCurrentRequest().getSession().getAttribute("user");
    }
}