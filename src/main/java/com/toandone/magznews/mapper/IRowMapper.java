/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.mapper;

import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public interface IRowMapper<T> {
    T mapRow(ResultSet rs);
}
