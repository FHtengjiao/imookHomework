package com.xtjnoob.service;

import com.xtjnoob.entity.Department;

import java.util.List;

public interface DepartmentService {
    void insert(Department department);

    void update(Department department);

    void delete(Long id);

    List<Department> getDepartmentsByCategory(Long categoryId);

    Department getDepartmentById(Long id);
}
