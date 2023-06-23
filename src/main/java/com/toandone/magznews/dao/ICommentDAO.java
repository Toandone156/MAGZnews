/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.dao;

import com.toandone.magznews.model.CommentModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ICommentDAO extends GenericDAO{
    List<CommentModel> getByNewsId(Long newsId);
    Long save(CommentModel comment);
}
