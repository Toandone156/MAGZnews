/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.service;

import com.toandone.magznews.model.CategoryModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ICategoryService {
    public List<CategoryModel> findAll();
    public CategoryModel findById(Long id);
    public CategoryModel findByCode(String code);
}
