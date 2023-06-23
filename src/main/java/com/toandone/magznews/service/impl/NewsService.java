/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.service.impl;

import com.toandone.magznews.dao.ICategoryDAO;
import com.toandone.magznews.dao.INewsDAO;
import com.toandone.magznews.model.CategoryModel;
import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.paging.Pageable;
import com.toandone.magznews.service.INewsService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class NewsService implements INewsService {

    @Inject
    INewsDAO news;

    @Inject
    ICategoryDAO category;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return news.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        newsModel.setCreatedDate(new Date(System.currentTimeMillis()));
        Long id = news.save(newsModel);
        return news.findOne(id);
    }

    @Override
    public NewsModel update(NewsModel updateNewsModel) {
        NewsModel oldNews = news.findOne(updateNewsModel.getId());
        updateNewsModel.setCreatedBy(oldNews.getCreatedBy());
        updateNewsModel.setCreatedDate(oldNews.getCreatedDate());
        updateNewsModel.setModifiedDate(new Date(System.currentTimeMillis()));
        
        news.update(updateNewsModel);
        return news.findOne(updateNewsModel.getId());
    }

    @Override
    public NewsModel delete(NewsModel deleteNews) {
        Long id = deleteNews.getId();
        
        news.delete(id);
        
        return news.findOne(id);
    }

    @Override
    public List<NewsModel> findAll(Pageable pageable) {
        return news.findAll(pageable);
    }

    @Override
    public Integer count() {
        return news.count();
    }

    @Override
    public NewsModel findOne(Long id) {
        NewsModel newsById = news.findOne(id);
        return newsById;
    }

    @Override
    public List<NewsModel> findByCreator(String creator) {
        return news.findByCreator(creator);
    }

    @Override
    public List<NewsModel> search(String key) {
        key = "%" + key + "%";
        return news.search(key);
    }

    @Override
    public void updateView(Integer view, Long id) {
        news.updateView(view, id);
    }

    @Override
    public List<NewsModel> findByIdList(Long[] ids) {
        List<NewsModel> list = new ArrayList<>();
        
        for(Long id: ids){
            list.add(news.findOne(id));
        }
        
        return list;
    }
}
