/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.mapper.impl;

import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.CommentModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class CommentMapper implements IRowMapper<CommentModel> {

    @Override
    public CommentModel mapRow(ResultSet rs) {
        try {
            CommentModel comment = new CommentModel();
            comment.setId(rs.getLong("id"));
            comment.setDesc(rs.getString("description"));
            AccountModel acc = new AccountModel();
            acc.setId(rs.getLong("accId"));
            acc.setFullName(rs.getString("fullname"));
            comment.setAccount(acc);
            comment.setNewsId(rs.getLong("newsId"));
            comment.setCreatedDate(rs.getDate("createddate"));
            comment.setCreatedBy(rs.getString("createdby"));
            return comment;
        } catch (SQLException ex) {
            return null;
        }
    }

}
