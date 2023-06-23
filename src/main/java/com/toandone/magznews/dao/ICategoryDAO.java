package com.toandone.magznews.dao;

import com.toandone.magznews.model.CategoryModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ICategoryDAO extends GenericDAO{
    public List<CategoryModel> findAll();
    public CategoryModel findOne(Long categoryId);
    public CategoryModel findByCode(String code);
}
