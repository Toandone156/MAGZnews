/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.toandone.magznews.controller.web;

import com.toandone.magznews.paging.PageRequest;
import com.toandone.magznews.service.ICategoryService;
import com.toandone.magznews.service.INewsService;
import com.toandone.magznews.sort.Sorter;
import java.io.IOException;
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
@WebServlet(name = "CategoryController", urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {

    @Inject
    ICategoryService category;

    @Inject
    INewsService news;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id == null) {
            request.setAttribute("newsList", news.findAll(null));
        } else {
            Long categoryId = Long.valueOf(id);

            request.setAttribute("category", category.findById(categoryId));
            request.setAttribute("newsList", news.findByCategoryId(categoryId));
        }
        
        request.setAttribute("popularList", news.findAll(new PageRequest(1, 4, new Sorter("viewer", "DESC"))));
        request.setAttribute("lastestList", news.findAll(new PageRequest(1, 4, new Sorter("createddate", "DESC"))));

        request.getRequestDispatcher("views/web/category.jsp").forward(request, response);
    }
}
