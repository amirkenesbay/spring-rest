package com.amirkenesbay.spring.rest.service;

import com.amirkenesbay.spring.rest.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartments();

    public void saveDepartment(Department department);

    public Department getDepartment(int id);

    public void deleteDepartment(int id);
}
