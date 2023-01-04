package com.Learning.DepartmentProject.controller;

import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public Iterable<Department> getAll(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name")String departmentName){
        return departmentService.getDepartmentName(departmentName);
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
    }
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id")Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }


}
