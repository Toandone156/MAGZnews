/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class CookieUtil {

    public CookieUtil() {
    }
    
    public void setCookie(String name, String value, int age, HttpServletResponse response){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(age);
        response.addCookie(cookie);
    }
    
    public String getCookieValue(String name, HttpServletRequest request){
        Cookie cookie = getCookie(name, request);
        return  cookie != null ? cookie.getValue() : null;
    }
    
    public Cookie getCookie(String name, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        
        for(Cookie cookie: cookies){
            if(cookie.getName().equals(name)){
                return cookie;
            }
        }
        
        return null;
    }
    
    public void removeCookie(String name, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = getCookie(name, request);
        
        if(cookie != null){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}
