package com.xtjnoob.service;

import com.xtjnoob.entity.Category;

import java.util.List;

public interface CategoryService {
    void insert(Category category);

    void update(Category category);

    public void delete(Long id);

    public Category getCategoryById(Long id);

    public List<Category> getAllCategories();
}
