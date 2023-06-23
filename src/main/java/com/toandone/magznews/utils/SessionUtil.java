/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author LENOVO
 */
public class SessionUtil {
    
    private static SessionUtil sessionUtil;
    
    public static SessionUtil getInstance(){
        if(sessionUtil != null)
            return sessionUtil;
        return new SessionUtil();
    }
    
    public void putValue(HttpServletRequest request, String key, Object value){
        request.getSession().setAttribute(key, value);
    }
    
    public Object getValue(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }
    
    public void removeValue(HttpServletRequest request, String key){
        request.getSession().removeAttribute(key);
    }
}
