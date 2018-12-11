package com.xtjnoob.controller;

import com.xtjnoob.entity.Category;
import com.xtjnoob.entity.Department;
import com.xtjnoob.service.CategoryService;
import com.xtjnoob.service.DepartmentService;
import com.xtjnoob.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("category_id");

        if (StringUtils.isNotEmpty(categoryId)) {
            try {
                long id = Long.parseLong(categoryId);
                List<Department> departments = departmentService.getDepartmentsByCategory(id);
                List<Category> categories = categoryService.getAllCategories();
                request.setAttribute("CATEGORIES", categories);
                request.setAttribute("DEPARTMENTS", departments);
                request.getRequestDispatcher("/WEB-INF/views/biz/department_list.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/category/list.do");
            }
        } else {
            response.sendRedirect("/category/list.do");
        }
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String categoryId = request.getParameter("category_id");

        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(categoryId)) {
            try {
                long departmentId = Long.parseLong(id);
                Department department = departmentService.getDepartmentById(departmentId);
                List<Category> categories = categoryService.getAllCategories();
                request.setAttribute("CATEGORIES", categories);
                request.setAttribute("DEPARTMENT", department);
                request.getRequestDispatcher("/WEB-INF/views/biz/department_edit.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/department/list.do?category_id="+categoryId);
            }
        } else {
            response.sendRedirect("/department/list.do?category_id="+categoryId);
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String categoryId = request.getParameter("category_id");

        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(categoryId)) {
            try {
                long departmentId = Long.parseLong(id);
                Department department = departmentService.getDepartmentById(departmentId);
                department.setName(name);
                department.setCategoryId(Long.parseLong(categoryId));
                departmentService.update(department);
                response.sendRedirect("/department/list.do?category_id="+categoryId);
            } catch (NumberFormatException e) {
                response.sendRedirect("/department/toEdit.do?id="+id+"&category_id="+categoryId);
            }
        } else {
            response.sendRedirect("/department/toEdit.do?id="+id+"&category_id="+categoryId);
        }
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategories();
        request.setAttribute("CATEGORIES", categories);
        request.getRequestDispatcher("/WEB-INF/views/biz/department_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String categoryId = request.getParameter("category_id");

        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(categoryId)) {
            Department department = new Department();
            department.setName(name);
            department.setCategoryId(Long.parseLong(categoryId));
            departmentService.insert(department);
            response.sendRedirect("/department/list.do?category_id="+categoryId);
        } else {
            response.sendRedirect("/department/toAdd.do");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String categoryId = request.getParameter("category_id");

        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(categoryId)) {
            try {
                long departmentId = Long.parseLong(id);
                departmentService.delete(departmentId);
                response.sendRedirect("/department/list.do?category_id="+categoryId);
            } catch (NumberFormatException e) {
                response.sendRedirect("/department/list.do?category_id="+categoryId);
            }
        } else {
            response.sendRedirect("/department/list.do?category_id="+categoryId);
        }
    }
}
