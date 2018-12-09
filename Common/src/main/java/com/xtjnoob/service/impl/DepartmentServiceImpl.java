package com.xtjnoob.service.impl;

import com.xtjnoob.dao.DepartmentDao;
import com.xtjnoob.entity.Department;
import com.xtjnoob.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void insert(Department department) {
        department.setCreateTime(new Date());
        departmentDao.insert(department);
    }

    public void update(Department department) {
        department.setUpdateTime(new Date());
        departmentDao.update(department);
    }

    public void delete(Long id) {
        departmentDao.delete(id);
    }

    public List<Department> getDepartmentsByCategory(Long categoryId) {
        return departmentDao.getDepartmentsByCategory(categoryId);
    }

    public Department getDepartmentById(Long id) {
        return departmentDao.getDepartmentById(id);
    }
}
