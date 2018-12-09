package com.xtjnoob.dao;

import com.xtjnoob.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    void insert(Department department);

    void update(Department department);

    void delete(Long id);

    List<Department> getDepartmentsByCategory(Long categoryId);

    Department getDepartmentById(Long id);
}
