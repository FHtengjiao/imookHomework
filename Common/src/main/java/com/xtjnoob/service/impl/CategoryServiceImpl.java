package com.xtjnoob.service.impl;

import com.xtjnoob.dao.CategoryDao;
import com.xtjnoob.entity.Category;
import com.xtjnoob.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public void insert(Category category) {
        category.setCreateTime(new Date());
        categoryDao.insert(category);
    }

    public void update(Category category) {
        category.setUpdateTime(new Date());
        categoryDao.update(category);
    }

    public void delete(Long id) {
        categoryDao.delete(id);
    }

    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
