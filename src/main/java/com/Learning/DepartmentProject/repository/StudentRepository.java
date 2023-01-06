package com.Learning.DepartmentProject.repository;

import com.Learning.DepartmentProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
