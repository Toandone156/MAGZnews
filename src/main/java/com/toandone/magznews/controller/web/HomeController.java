/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.toandone.magznews.controller.web;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.CommentModel;
import com.toandone.magznews.model.NewsModel;
import com.toandone.magznews.model.RoleModel;
import com.toandone.magznews.paging.PageRequest;
import com.toandone.magznews.service.IAccountService;
import com.toandone.magznews.service.ICategoryService;
import com.toandone.magznews.service.ICommentService;
import com.toandone.magznews.service.INewsService;
import com.toandone.magznews.sort.Sorter;
import com.toandone.magznews.utils.CookieUtil;
import com.toandone.magznews.utils.FormUtil;
import com.toandone.magznews.utils.SessionUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
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
@WebServlet(name = "WebController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @Inject
    ICategoryService category;

    @Inject
    INewsService news;

    @Inject
    ICommentService commentService;

    @Inject
    IAccountService account;

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

        String action = request.getParameter("action");
        String view = "";

        if (action != null) {
            switch (action) {
                case "view":
                    Long id = Long.valueOf(request.getParameter("id"));
                    NewsModel newsById = news.findOne(id);
                    news.updateView(newsById.getViewer() + 1, id);

                    List<CommentModel> commentList = commentService.findByNewsId(id);

                    addToCookie(request, response, id);

                    request.setAttribute("news", newsById);
                    request.setAttribute("commentList", commentList);
                    view = "views/web/single.jsp";
                    break;
                case "search":
                    String keyword = request.getParameter("key");

                    request.setAttribute("searchList", news.search(keyword));
                    request.setAttribute("key", keyword);
                    view = "views/web/search.jsp";
                    break;
                case "profile":

                    if (SessionUtil.getInstance().getValue(request, "USERMODEL") == null) {
                        response.sendRedirect("login?action=login&message=not_login&type=error");
                        return;
                    }

                    view = "views/profile.jsp";
                    break;
                default:
                    request.setAttribute("historyList", getHistoryList(request, response));
                    view = "views/web/home.jsp";
            }
        } else {
            request.setAttribute("historyList", getHistoryList(request, response));
            view = "views/web/home.jsp";
        }
        
        request.setAttribute("popularList", news.findAll(new PageRequest(1, 4, new Sorter("viewer", "DESC"))));
        request.setAttribute("lastestList", news.findAll(new PageRequest(1, 4, new Sorter("createddate", "DESC"))));
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel acc = new FormUtil().toModel(AccountModel.class, req);

        if (acc.getAction() != null) {
            switch (acc.getAction()) {
                case "profile":
                    RoleModel role = new RoleModel();
                    role.setId(Long.valueOf(req.getParameter("roleId")));
                    acc.setRole(role);
                    account.update(acc);

                    SessionUtil.getInstance().putValue(req, "USERMODEL", account.findById(acc.getId()));

                    resp.sendRedirect("home?message=update_success&type=success");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    void addToCookie(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
        String idAdd = id.toString();

        String value = new CookieUtil().getCookieValue("historyList", request);

        LinkedList<String> historyList = value != null ? new LinkedList<>(Arrays.asList(value.split("-"))) : new LinkedList<String>();

        if (!historyList.contains(idAdd)) {
            historyList.addFirst(idAdd);
        } else {
            historyList.remove(idAdd);
            historyList.addFirst(idAdd);
        }

        if (historyList.size() > 4) {
            historyList.remove(historyList.size() - 1);
        }

        new CookieUtil().setCookie("historyList", String.join("-", historyList), 60 * 60 * 24 * 365, response);
    }

    List<NewsModel> getHistoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = new CookieUtil().getCookieValue("historyList", request);

        String[] preIds = value.split("-");

        Long[] ids = new Long[preIds.length];

        for (int i = 0; i < ids.length; i++) {
            ids[i] = Long.valueOf(preIds[i]);
        }

        return news.findByIdList(ids);
    }
}
