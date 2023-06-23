/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.toandone.magznews.controller.web;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.CommentModel;
import com.toandone.magznews.paging.PageRequest;
import com.toandone.magznews.service.ICategoryService;
import com.toandone.magznews.service.ICommentService;
import com.toandone.magznews.service.INewsService;
import com.toandone.magznews.sort.Sorter;
import com.toandone.magznews.utils.FormUtil;
import com.toandone.magznews.utils.SessionUtil;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CommentController", urlPatterns = {"/comment"})
public class CommentController extends HttpServlet {

    @Inject
    INewsService news;

    @Inject
    ICommentService commentService;

    ResourceBundle rb = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");
        String type = request.getParameter("type");

        if (message != null && type != null) {
            request.setAttribute("message", rb.getString(message));
            request.setAttribute("type", type);
        }

        request.setAttribute("lastestList", news.findAll(new PageRequest(1, 4, new Sorter("createddate", "DESC"))));
        request.getRequestDispatcher("views/web/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentModel commentModel = new FormUtil().toModel(CommentModel.class, request);
        
        String message = request.getParameter("message");
        String type = request.getParameter("type");

        if (message != null && type != null) {
            request.setAttribute("message", rb.getString(message));
            request.setAttribute("type", type);
        }
        
        String action = commentModel.getAction();  
        
        if(action != null){
            switch (action) {
                case "create":
                    AccountModel acc = (AccountModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
                    
                    if(acc != null){
                        commentModel.setAccount(acc);
                        commentService.save(commentModel);
                        response.sendRedirect("home?action=view&id=" + commentModel.getNewsId());
                    }else{
                        response.sendRedirect("login?action=login&message=not_login&type=error");
                    }
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }else{
            request.setAttribute("lastestList", news.findAll(new PageRequest(1, 4, new Sorter("createddate", "DESC"))));
            request.getRequestDispatcher("views/web/home.jsp").forward(request, response);
        }

        
    }

}
