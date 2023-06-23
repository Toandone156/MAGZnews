/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.service.impl;

import com.toandone.magznews.dao.ICategoryDAO;
import com.toandone.magznews.model.CategoryModel;
import com.toandone.magznews.service.ICategoryService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class CategoryService implements ICategoryService{
    
    @Inject
    private ICategoryDAO category;

    @Override
    public List<CategoryModel> findAll() {
        return category.findAll();
    }

    @Override
    public CategoryModel findById(Long id) {
        return category.findOne(id);
    }

    @Override
    public CategoryModel findByCode(String code) {
        return category.findByCode(code);
    }
    
}
