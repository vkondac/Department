package com.Learning.DepartmentProject.repository;

import com.Learning.DepartmentProject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
