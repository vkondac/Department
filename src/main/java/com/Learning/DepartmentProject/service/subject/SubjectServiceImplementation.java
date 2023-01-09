package com.Learning.DepartmentProject.service.subject;

import com.Learning.DepartmentProject.entity.Subject;
import com.Learning.DepartmentProject.repository.SubjectRepository;
import com.Learning.DepartmentProject.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImplementation implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject){
       return subjectRepository.save(subject);
    }
}
