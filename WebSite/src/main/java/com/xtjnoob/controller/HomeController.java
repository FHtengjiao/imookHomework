package com.xtjnoob.controller;

import com.xtjnoob.entity.Category;
import com.xtjnoob.entity.Department;
import com.xtjnoob.service.CategoryService;
import com.xtjnoob.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller("siteController")
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DepartmentService departmentService;

    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategories();
        Map<String, List<Department>> map = new LinkedHashMap<>();
        List<Department> departments = null;
        for (Category category : categories) {
            departments = departmentService.getDepartmentsByCategory(category.getId());
            if (departments.size() != 0) {
                map.put(category.getName(), departments);
            }
        }
        request.setAttribute("MAP", map);
        request.getRequestDispatcher("/WEB-INF/views/biz/hospital_detail.jsp").forward(request,response);
    }
}
