package com.Learning.DepartmentProject.controller;

import com.Learning.DepartmentProject.entity.Subject;
import com.Learning.DepartmentProject.repository.SubjectRepository;
import com.Learning.DepartmentProject.service.subject.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @PostMapping("/subjects")
    public Subject saveSubject(@Valid @RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }
}
