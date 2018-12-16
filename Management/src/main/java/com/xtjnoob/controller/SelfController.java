package com.xtjnoob.controller;

import com.xtjnoob.entity.User;
import com.xtjnoob.service.UserService;
import com.xtjnoob.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private UserService userService;

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (StringUtils.isNotEmpty(account) && StringUtils.isNotEmpty(password)) {
            User user = userService.login(account, password);
            if (user != null) {
                request.getSession().setAttribute("USER", user);
                response.sendRedirect("/category/list.do");
            } else {
                response.sendRedirect("/toLogin.do");
            }
        } else {
            response.sendRedirect("/toLogin.do");
        }
    }

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request, response);
    }
}
