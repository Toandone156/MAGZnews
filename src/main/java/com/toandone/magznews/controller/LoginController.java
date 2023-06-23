/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.toandone.magznews.controller;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.RoleModel;
import com.toandone.magznews.service.IAccountService;
import com.toandone.magznews.service.ICategoryService;
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
@WebServlet(name = "LoginController", urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {

    @Inject
    IAccountService account;

    @Inject
    ICategoryService category;

    ResourceBundle rb = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        String message = request.getParameter("message");
        String type = request.getParameter("type");

        if (message != null && type != null) {
            request.setAttribute("message", rb.getString(message));
            request.setAttribute("type", type);
        }

        if (action != null) {
            switch (action) {
                case "login":
                    request.getRequestDispatcher("views/login.jsp").forward(request, response);
                    break;
                case "register":
                    request.getRequestDispatcher("views/register.jsp").forward(request, response);
                    break;
                case "logout":
                    SessionUtil.getInstance().removeValue(request, "USERMODEL");
                    response.sendRedirect(request.getContextPath() + "/home?message=logout_success&type=success");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            String view = "";
            AccountModel model = new FormUtil().toModel(AccountModel.class, request);

            switch (action) {
                case "login":
                    AccountModel acc = account.findByUserAndPass(model.getUser(), model.getPass());

                    if (acc != null) {
                        SessionUtil.getInstance().putValue(request, "USERMODEL", acc);
                        if (acc.getRole().getCode().equals("admin")) {
                            view = "admin-news?message=login_success&type=success";
                        } else {
                            view = "home?message=login_success&type=success";
                        }
                    } else {
                        view = "login?action=login&message=user_pass_wrong&type=error";
                    }
                    response.sendRedirect(view);
                    break;
                case "register":
                    RoleModel role = new RoleModel();
                    role.setId(2L); //User
                    model.setRole(role);

                    Long id = account.save(model);

                    AccountModel registerAcc = account.findByUserAndPass(model.getUser(), model.getPass());

                    if (id != null) {
                        SessionUtil.getInstance().putValue(request, "USERMODEL", registerAcc);
                        view = "home?message=register_success&type=success";
                    }else{
                        view = "login?action=register&message=something_wrong&type=error";
                    }
                    response.sendRedirect(view);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
