package com.Learning.DepartmentProject.service.department;

import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.error.department.DepartmentNotFoundException;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;

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

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not avaiable");
        }
        return department.get();
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

    public Department getDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    public Iterable<Department> getSmallDepartments() {
        Predicate<Department> smallCondition = department -> department.getSeatNumber() < 300;
        return departmentRepository.findAll(Sort.by(Sort.Direction.ASC, "seatNumber")).stream().filter(smallCondition).toList();
    }

    public Iterable<Department> getDepartmentsBySeatNumber(Integer seatNumber) {
        return departmentRepository.findBySeatNumber(seatNumber);
    }

}
