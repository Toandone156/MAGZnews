/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.service;

import com.toandone.magznews.model.CommentModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ICommentService {
    List<CommentModel> findByNewsId(Long newsId);
    Long save(CommentModel comment);
}
