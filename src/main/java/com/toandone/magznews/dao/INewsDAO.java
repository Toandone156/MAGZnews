/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.dao;

import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.paging.Pageable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface INewsDAO extends GenericDAO{
    NewsModel findOne(Long id);
    List<NewsModel> findByCategoryId(Long categoryId);
    Long save(NewsModel newsModel);
    void update(NewsModel updateNews);
    void delete(Long id);
    List<NewsModel> findAll(Pageable pageable);
    Integer count();
    List<NewsModel> findByCreator(String creator);
    List<NewsModel> search(String ketword);
    void updateView(Integer view, Long id);
}
