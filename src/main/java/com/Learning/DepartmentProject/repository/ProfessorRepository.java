package com.Learning.DepartmentProject.repository;

import com.Learning.DepartmentProject.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>{
}
