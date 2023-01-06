package com.Learning.DepartmentProject.service;

import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.error.DepartmentNotFoundException;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public Iterable<Department> getAllDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public ResponseEntity<Department> updateDepartment(Long departmentId, Department department);

    public Department getDepartmentName(String departmentName);

    public Iterable<Department> getSmallDepartments();

    public Iterable<Department> getDepartmentsBySeatNumber(Integer seatNumber);
}
