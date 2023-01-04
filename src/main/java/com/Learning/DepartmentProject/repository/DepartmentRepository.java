package com.Learning.DepartmentProject.repository;

import com.Learning.DepartmentProject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String name);
    public Iterable<Department> findBySeatNumber(Integer seatNumber);
}
