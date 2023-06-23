/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.toandone.magznews.controller.admin;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.CategoryModel;
import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.service.ICategoryService;
import com.toandone.magznews.service.INewsService;
import com.toandone.magznews.utils.FormUtil;
import com.toandone.magznews.utils.SessionUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "HomeController", urlPatterns = {"/admin-news"})
public class HomeController extends HttpServlet {

    @Inject
    INewsService newsService;

    @Inject
    ICategoryService categoryService;

    ResourceBundle rb = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsModel newsModel = new FormUtil().toModel(NewsModel.class, request);
        String action = newsModel.getAction();
        String view = "";

        String message = request.getParameter("message");
        String type = request.getParameter("type");

        if (message != null && type != null) {
            request.setAttribute("message", rb.getString(message));
            request.setAttribute("type", type);
        }

        AccountModel acc = (AccountModel) SessionUtil.getInstance().getValue(request, "USERMODEL");

        if (action != null) {
            switch (action) {
                case "list":
                    switch (acc.getRole().getCode()) {
                        case "creator":
                            newsModel.setListResult(newsService.findByCreator(acc.getFullName()));
                            break;
                        case "admin":
                            newsModel.setListResult(newsService.findAll(null));
                            break;
                    }

                    view = "/views/admin/list.jsp";
                    break;
                case "edit":
                    Long id = newsModel.getId();

                    if (id != null) {
                        //Update news
                        NewsModel updateNews = newsService.findOne(id);
                        newsModel.setTitle(updateNews.getTitle());
                        newsModel.setThumnail(updateNews.getThumnail());
                        newsModel.setShortDesc(updateNews.getShortDesc());
                        newsModel.setDesc(updateNews.getDesc());
                        newsModel.setCategory(updateNews.getCategory());
                    }

                    List<CategoryModel> category = categoryService.findAll();
                    request.setAttribute("categories", category);
                    view = "views/admin/edit.jsp";
                    break;
                case "account":
                    
                    view = "views/admin/account.jsp";
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            view = "views/admin/home.jsp";
        }
        request.setAttribute("model", newsModel);
        request.getRequestDispatcher(view).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsModel newsModel = new FormUtil().toModel(NewsModel.class, request);
        String action = newsModel.getAction();
        String user = ((AccountModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getFullName();

        newsModel.setCreatedBy(user);
        newsModel.setModifiedBy(user);

        newsModel.setCategory(categoryService.findByCode(request.getParameter("categoryCode")));
        
        String view = "admin-news?action=list";
        
        if (action != null) {
            switch (action) {
                case "create":
                    newsModel = newsService.save(newsModel);
                    if(newsModel != null){
                        view += "&message=add_success&type=success";
                    }else{
                        view += "&message=add_fail&type=error";
                    }
                    break;
                case "update":
                    newsModel = newsService.update(newsModel);
                    if(newsModel != null){
                        view += "&message=update_success&type=success";
                    }else{
                        view += "&message=update_fail&type=error";
                    }
                    break;
                case "delete":
                    newsModel = newsService.delete(newsModel);
                    if(newsModel == null){
                        view += "&message=delete_success&type=success";
                    }else{
                        view += "&message=delete_fail&type=error";
                    }
                    break;
                default:
                    break;
            }
        }
        response.sendRedirect(view);
    }

}
