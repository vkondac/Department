package com.Learning.DepartmentProject.service.professor;

import com.Learning.DepartmentProject.entity.Professor;
import com.Learning.DepartmentProject.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImplementation implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor saveProfessor(Professor professor){
        return professorRepository.save(professor);
    }

}
