/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class HttpUtil {
    private String value;
    
    public HttpUtil(String value) {
        this.value = value;
    }
    
    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException ex) {
            return null;
        }
    }
    
    public static HttpUtil of (BufferedReader reader){
        StringBuilder sb = new StringBuilder();
        
        String line;
        try {
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new HttpUtil(sb.toString());
    }
}
