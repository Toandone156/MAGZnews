/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.dao.impl;

import com.toandone.magznews.dao.ICategoryDAO;
import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.mapper.impl.CategoryMapper;
import com.toandone.magznews.model.CategoryModel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> result = new LinkedList<>();
        String sql = "SELECT * FROM Category";
        IRowMapper mapper = new CategoryMapper();
        return query(sql, mapper);
    }

    @Override
    public CategoryModel findOne(Long categoryId) {
        List<CategoryModel> result = new LinkedList<>();
        String sql = "SELECT * FROM Category WHERE id=?";
        result = query(sql, new CategoryMapper(), categoryId);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public CategoryModel findByCode(String code) {
        List<CategoryModel> result = new LinkedList<>();
        String sql = "SELECT * FROM Category WHERE code=?";
        result = query(sql, new CategoryMapper(), code);
        return result.isEmpty() ? null : result.get(0);
    }
}
