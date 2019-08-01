package com.fly.demo.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.08.01 11:24  
 */
public class HttpUtil {


    public static HttpServletRequest request() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request;
    }

    public static HttpServletResponse response(){
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        return response;
    }


    public static HttpSession session(){
        return request().getSession();
    }

}
