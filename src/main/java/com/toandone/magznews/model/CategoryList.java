/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.model;

import com.toandone.magznews.dao.impl.CategoryDAO;
import com.toandone.magznews.service.ICategoryService;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CategoryList implements Serializable{
    
    List<CategoryModel> list;

    public CategoryList() {
        list = (new CategoryDAO()).findAll();
    }

    public List<CategoryModel> getList() {
        return list;
    }

    public void setList(List<CategoryModel> list) {
        this.list = list;
    }
}

