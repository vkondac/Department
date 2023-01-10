package com.Learning.DepartmentProject.service.student;

import com.Learning.DepartmentProject.entity.Student;

import java.text.ParseException;

public interface StudentService {
    public Student getStudentById(Long studentId);
    public Student saveStudent(Student student);
    public Student assignSubjectsToStudent(Long subjectId, Long studentId);
}
