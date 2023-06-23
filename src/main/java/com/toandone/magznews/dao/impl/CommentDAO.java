/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.dao.impl;

import com.toandone.magznews.dao.ICommentDAO;
import com.toandone.magznews.mapper.impl.CommentMapper;
import com.toandone.magznews.model.CommentModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO{

    @Override
    public List<CommentModel> getByNewsId(Long newsId) {
        List<CommentModel> list = new ArrayList<>();
        
        String sql = "SELECT * FROM dbo.comment INNER JOIN dbo.account ON account.id = comment.accId WHERE newsId = ? ORDER BY comment.id DESC";
        
        list = query(sql, new CommentMapper(), newsId);
        
        return list;
    }

    @Override
    public Long save(CommentModel comment) {
        String sql = "INSERT INTO dbo.comment ( description, newsId, accId, createddate, createdby) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        return insert(sql, comment.getDesc(), comment.getNewsId(), comment.getAccount().getId(), 
                comment.getCreatedDate(), comment.getCreatedBy());
    }
    
}
