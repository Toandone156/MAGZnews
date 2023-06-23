/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.filter;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.utils.SessionUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rp = (HttpServletResponse) response;

        String uri = rq.getRequestURI();

        System.out.println(uri);

        if (!uri.endsWith(".jsp")) {
            if (uri.contains("/admin")) {
                AccountModel acc = (AccountModel) SessionUtil.getInstance().getValue(rq, "USERMODEL");

                if (acc != null) {

                    switch (acc.getRole().getCode()) {
                        case "admin":
                            chain.doFilter(request, response);
                            break;
                        case "creator":
                            if (uri.contains("/admin-account")) {
                                rp.sendRedirect("admin-news?message=not_permission&type=error");
                            } else {
                                chain.doFilter(request, response);
                            }
                            break;
                        default:
                            rp.sendRedirect("login?action=login&message=not_permission&type=error");
                    }
                } else {
                    rp.sendRedirect("login?action=login&message=not_login&type=error");
                }

            } else {
                chain.doFilter(request, response);
            }
        }else{
            rp.sendRedirect("home");
        }
    }

    @Override
    public void destroy() {

    }

}
