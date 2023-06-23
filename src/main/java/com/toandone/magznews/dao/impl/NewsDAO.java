/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.dao.impl;

import com.toandone.magznews.dao.INewsDAO;
import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.mapper.impl.NewsMapper;
import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.paging.Pageable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news INNER JOIN dbo.category ON category.id = news.categoryId WHERE categoryId = ?";
        IRowMapper mapper = new NewsMapper();
        return query(sql, mapper, categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "INSERT INTO news (title, thumnail, shortdesc, description, categoryId, "
                + "createddate, createdby, modifieddate, modifiedby) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, newsModel.getTitle(), newsModel.getThumnail(), newsModel.getShortDesc(),
                newsModel.getDesc(), newsModel.getCategory().getId(), newsModel.getCreatedDate(), newsModel.getCreatedBy(),
                newsModel.getModifiedDate(), newsModel.getModifiedBy());
    }

    @Override
    public NewsModel findOne(Long id) {
        String sql = "SELECT * FROM news LEFT OUTER JOIN dbo.category ON category.id = news.categoryId WHERE news.id = ?";
        List<NewsModel> result = query(sql, new NewsMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public void update(NewsModel updateNews) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumnail = ?,");
        sql.append(" shortdesc = ?, description = ?, categoryId = ?,");
        sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateNews.getTitle(), updateNews.getThumnail(), updateNews.getShortDesc(),
                updateNews.getDesc(), updateNews.getCategory().getId(), updateNews.getCreatedDate(),
                updateNews.getCreatedBy(), updateNews.getModifiedDate(),
                updateNews.getModifiedBy(), updateNews.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM news WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<NewsModel> findAll(Pageable pageable) {
        Integer offset = null;
        Integer maxItemsPerPage = null;
        String sortBy = null;
        String sortType = null;

        if (pageable != null) {
            offset = pageable.getOffset();
            maxItemsPerPage = pageable.getMaxItemsPerPage();
            if (pageable.getSorter() != null) {
                sortBy = pageable.getSorter().getSortBy();
                sortType = pageable.getSorter().getSortType();
            }
        }

        StringBuilder sql = new StringBuilder("SELECT * FROM dbo.news LEFT OUTER JOIN dbo.category ON category.id = news.categoryId");

        if (sortBy != null && sortType != null) {
            sql.append(" ORDER BY news.").append(sortBy).append(" ").append(sortType);
        }

        if (offset != null && maxItemsPerPage != null) {
            sql.append(" OFFSET ").append(offset).append(" ROWS FETCH NEXT ").append(maxItemsPerPage)
                    .append(" ROWS ONLY");
        }

        return query(sql.toString(), new NewsMapper());
    }

    @Override
    public Integer count() {
        String sql = "SELECT count(*) FROM news";
        return count(sql);
    }

    @Override
    public List<NewsModel> findByCreator(String creator) {
        String sql = "SELECT * FROM dbo.news INNER JOIN dbo.category ON category.id = news.categoryId WHERE news.createdby = ?";
        return query(sql, new NewsMapper(), creator);
    }

    @Override
    public List<NewsModel> search(String key) {
        String sql = "SELECT * FROM dbo.news INNER JOIN dbo.category ON category.id = news.categoryId WHERE title LIKE ? OR shortdesc LIKE ? OR description LIKE ?";
        return query(sql, new NewsMapper(), key, key, key);
    }

    @Override
    public void updateView(Integer view, Long id) {
        String sql = "UPDATE dbo.news SET viewer = ? WHERE id = ?";
        insert(sql, view, id);
    }
}
