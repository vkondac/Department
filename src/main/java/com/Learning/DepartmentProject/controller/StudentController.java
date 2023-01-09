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
//    @PutMapping("/students/{studentId}/department/{departmendId}")
//    public Student assignDepartmentToStudent(@PathVariable Long studentId, @PathVariable Long departmendId){
//        return studentService.assignDepartmentToStudent(studentId, departmendId);
//    }
}
