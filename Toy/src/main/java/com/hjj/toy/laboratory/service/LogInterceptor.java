package com.hjj.toy.laboratory.service;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {

//    private final static String SESSION_TOKEN_KEY = "thread";
    private final static String SESSION_TOKEN_KEY = "sessionTokenId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        MDC. put(SESSION_TOKEN_KEY, token);
//        Thread.currentThread().setName(token);
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.post(request, response, handler);
//    }
//
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC. remove(SESSION_TOKEN_KEY);
    }
}
