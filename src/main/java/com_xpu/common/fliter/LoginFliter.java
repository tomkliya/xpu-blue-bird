package com_xpu.common.fliter;

import cn.hutool.json.JSONUtil;
import com_xpu.common.Context.RequestContext;
import com_xpu.domain.entity.Result;
import com_xpu.domain.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器
 */
@Component
public class LoginFliter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        // 获取请求的URI
        String uri = request.getRequestURI();

        // 判断是否需要登录
        if (uri.contains("/login") || uri.contains("/register") || uri.contains("/index") || uri.contains("/static")) {
            // 放行不需要登录的请求
            filterChain.doFilter(request, response);
            return;
        }

        // 判断是否已经登录
        Users user =  RequestContext.getCurrentUser();
        if (user !=null) {
            // 已经登录，放行请求
            filterChain.doFilter(request, response);
            return;
        }
        // 走到这里就代表是其他接口，且没有登录
        // 设置响应数据类型为json（前后端分离）
        response.setContentType("application/json;charset=utf-8");
        // 构建 ApiResult 对象
        Result<Void> Result = new Result<>();
        // 未授权
        Result.setCode(HttpStatus.UNAUTHORIZED.value());
        Result.setMessage("请先登录");
        Result.setData(null);
        // 将 ApiResult 对象转换为 JSON 字符串
        String jsonResponse = JSONUtil.toJsonStr(Result);
        PrintWriter out = response.getWriter();
        // 设置响应内容，结束请求
        out.write(jsonResponse);
        out.flush();
        out.close();
    }
}
