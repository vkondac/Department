package com.Learning.DepartmentProject.controller;

import com.Learning.DepartmentProject.entity.Student;
import com.Learning.DepartmentProject.service.student.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }
    @PostMapping("/students")
    public Student saveStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping("/students/{studentId}/subjects/{subjectId}")
    public Student assignSubjectsToStudent(@PathVariable(name = "subjectId") Long subjectId, @PathVariable(name = "studentId") Long studentId){
        return studentService.assignSubjectsToStudent(subjectId,studentId);
    }
}
