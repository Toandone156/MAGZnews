/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.mapper.impl;

import com.toandone.magznews.dao.ICategoryDAO;
import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.model.CategoryModel;
import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.service.ICategoryService;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class NewsMapper implements IRowMapper<NewsModel> {

    @Override
    public NewsModel mapRow(ResultSet rs) {
        try {
            NewsModel news = new NewsModel();
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getNString("title"));
            news.setThumnail(rs.getNString("thumnail"));
            news.setShortDesc(rs.getNString("shortdesc"));
            news.setDesc(rs.getNString("description"));
            CategoryModel category = new CategoryModel();
            category.setId(rs.getLong("categoryId"));
            category.setCode(rs.getString("code"));
            category.setName(rs.getString("name"));
            news.setViewer(rs.getInt("viewer"));
            news.setCategory(category);
            news.setCreatedDate(rs.getDate("createddate"));
            news.setCreatedBy(rs.getNString("createdby"));
            if (rs.getDate("modifieddate") != null) {
                news.setModifiedDate(rs.getDate("modifieddate"));
            }
            if (rs.getNString("modifiedby") != null) {
                news.setModifiedBy(rs.getNString("modifiedby"));
            }
            return news;
        } catch (SQLException ex) {
            return null;
        }
    }

}
