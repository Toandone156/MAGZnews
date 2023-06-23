/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.service;

import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.paging.Pageable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface INewsService {
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel updateNewsModel);
    NewsModel delete(NewsModel deleteNews);
    List<NewsModel> findAll(Pageable pageable);
    Integer count();
    NewsModel findOne(Long id);
    List<NewsModel> findByCreator(String creator);
    List<NewsModel> search(String key);
    void updateView(Integer view, Long id);
    List<NewsModel> findByIdList(Long[] ids);
}
