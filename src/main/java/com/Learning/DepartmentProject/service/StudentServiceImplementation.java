package com.Learning.DepartmentProject.service;

import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.entity.Student;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import com.Learning.DepartmentProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    public Student getStudentById(Long studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent()){
            throw new ResourceNotFoundException("Student not found");
        }
        return student.get();
    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student assignDepartmentToStudent(Long studentId, Long departmentId){
        Student student = studentRepository.findById(studentId).get();
        Department department = departmentRepository.findById(departmentId).get();
        student.setDepartment(department);
        return studentRepository.save(student);
    }

}
