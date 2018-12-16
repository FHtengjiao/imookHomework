package com.xtjnoob.global;

import com.xtjnoob.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "userFilter", urlPatterns = "*.do")
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String servletPath = request.getServletPath();
        if (servletPath.toLowerCase().contains("login")) {
            filterChain.doFilter(request, response);
        } else {
            User user = (User) request.getSession().getAttribute("USER");
            if (user == null) {
                response.sendRedirect("/toLogin.do");
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
