package com.xtjnoob.controller;

import com.xtjnoob.entity.Category;
import com.xtjnoob.service.CategoryService;
import com.xtjnoob.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("categoryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategories();
        request.setAttribute("CATEGORIES", categories);
        request.getRequestDispatcher("/WEB-INF/views/biz/category_list.jsp").forward(request, response);
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (StringUtils.isNotEmpty(id)) {
            try {
                long categoryId = Long.parseLong(id);
                Category category = categoryService.getCategoryById(categoryId);
                request.setAttribute("CATEGORY", category);
                request.getRequestDispatcher("/WEB-INF/views/biz/category_edit.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/category/list.do");
            }
        } else {
            response.sendRedirect("/category/list.do");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(name)) {
            try {
                long categoryId = Long.parseLong(id);
                Category category = categoryService.getCategoryById(categoryId);
                category.setName(name);
                categoryService.update(category);
                response.sendRedirect("/category/list.do");
            } catch (NumberFormatException e) {
                response.sendRedirect("/category/list.do");
            }
        } else {
            response.sendRedirect("/category/toEdit.do?id="+id);
        }
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/category_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        if (StringUtils.isNotEmpty(name)) {
            Category category = new Category();
            category.setName(name);
            categoryService.insert(category);
            response.sendRedirect("/category/list.do");
        } else {
            response.sendRedirect("/category/toAdd.do");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (StringUtils.isNotEmpty(id)) {
            try {
                long categoryId = Long.parseLong(id);
                categoryService.delete(categoryId);
                response.sendRedirect("/category/list.do");
            } catch (NumberFormatException e) {
                response.sendRedirect("/category/list.do");
            }
        } else {
            response.sendRedirect("/category/list.do");
        }
    }
}
