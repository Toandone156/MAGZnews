/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.utils;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author LENOVO
 */
public class FormUtil {

    public <T> T toModel(Class<T> tClass, HttpServletRequest rq) {
        T object = null;

        try {
            object = tClass.newInstance();
            BeanUtils.populate(object, rq.getParameterMap());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
        }
        return object;
    }
}
