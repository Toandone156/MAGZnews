/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.dao;

import com.toandone.magznews.mapper.IRowMapper;
import java.util.List;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public interface GenericDAO<T> {
    <T> List<T> query(String sql, IRowMapper<T> mapper, Object... parameters);
    <T> void update(String sql, Object... parameters);
    <T> Long insert(String sql, Object... parameters);
    <T> Integer count(String sql, Object... parameters);
}
