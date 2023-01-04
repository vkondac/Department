package com.Learning.DepartmentProject.service;

import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import com.Learning.DepartmentProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Long departmentId) {
       return departmentRepository.findById(departmentId).get();
    }
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public ResponseEntity<Department> updateDepartment(Long departmentId, Department department) {
       Department newDepartment = departmentRepository.findById(departmentId)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + departmentId));
       newDepartment.setDepartmentName(department.getDepartmentName());
       newDepartment.setDepartmentAddress(department.getDepartmentAddress());
       newDepartment.setDepartmentCode(department.getDepartmentCode());

       departmentRepository.save(newDepartment);

       return ResponseEntity.ok(newDepartment);
    }
    public Department getDepartmentName(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName);
    }

}
