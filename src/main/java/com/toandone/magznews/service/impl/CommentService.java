/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.service.impl;

import com.toandone.magznews.dao.ICommentDAO;
import com.toandone.magznews.model.CommentModel;
import com.toandone.magznews.service.ICommentService;
import java.sql.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class CommentService implements ICommentService{
    
    @Inject
    ICommentDAO comment;

    @Override
    public List<CommentModel> findByNewsId(Long newsId) {
        return comment.getByNewsId(newsId);
    }

    @Override
    public Long save(CommentModel commentModel) {
        commentModel.setCreatedDate(new Date(System.currentTimeMillis()));
        return comment.save(commentModel);
    }
    
}
