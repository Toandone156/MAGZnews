/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.toandone.magznews.controller.admin;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.RoleModel;
import com.toandone.magznews.service.IAccountService;
import com.toandone.magznews.service.IRoleService;
import com.toandone.magznews.utils.FormUtil;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "AccountController", urlPatterns = {"/admin-account"})
public class AccountController extends HttpServlet {

    @Inject
    IAccountService account;

    @Inject
    IRoleService role;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            request.setAttribute("roleList", role.getAll());

            switch (action) {
                case "list":
                    String roleIdSelected = request.getParameter("roleId");
                    Long roleId = roleIdSelected == null ? 0L : Long.valueOf(roleIdSelected);

                    List<AccountModel> accList = roleId == 0L ? account.getAll() : account.getByRoleId(roleId);

                    request.setAttribute("accList", accList);
                    request.setAttribute("roleSelected", roleId);

                    request.getRequestDispatcher("views/admin/account.jsp").forward(request, response);
                    break;
                case "create":
                    request.getRequestDispatcher("views/admin/editacc.jsp").forward(request, response);
                    break;
                case "update":
                    Long id = Long.valueOf(request.getParameter("id"));
                    AccountModel model = account.findById(id);
                    request.setAttribute("model", model);
                    request.getRequestDispatcher("views/admin/editacc.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountModel model = new FormUtil().toModel(AccountModel.class, request);
        String roleId = request.getParameter("roleId");
        if (roleId != null) {
            RoleModel roleModel = new RoleModel();
            roleModel.setId(Long.valueOf(request.getParameter("roleId")));
            model.setRole(roleModel);
        }
        if (model.getAction() != null) {
            switch (model.getAction()) {
                case "create":
                    account.save(model);
                    break;
                case "update":
                    account.update(model);
                    break;
                case "delete":
                    account.delete(model.getId());
                    break;
                default:
                    throw new AssertionError();
            }
            response.sendRedirect("admin-account?action=list");
        }
    }
}
