package com.xtjnoob.dao;

import com.xtjnoob.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    void insert(Category category);

    void update(Category category);

    void delete(Long id);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();
}
