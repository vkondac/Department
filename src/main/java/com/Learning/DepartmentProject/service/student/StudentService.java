package com.Learning.DepartmentProject.service.student;

import com.Learning.DepartmentProject.entity.Student;

public interface StudentService {
    public Student getStudentById(Long studentId);
    public Student saveStudent(Student student);
//    public Student assignDepartmentToStudent(Long studentId, Long departmentId);
}
