                                                      /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.mapper.impl;

import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.model.CategoryModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class CategoryMapper implements IRowMapper<CategoryModel>{

    @Override
    public CategoryModel mapRow(ResultSet rs) {
        try {
            CategoryModel category = new CategoryModel();
            category.setId(rs.getLong("id"));
            category.setCode(rs.getNString("code"));
            category.setName(rs.getNString("name"));
            return category;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
