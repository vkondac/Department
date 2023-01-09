package com.Learning.DepartmentProject.service.student;

import com.Learning.DepartmentProject.entity.Student;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import com.Learning.DepartmentProject.repository.StudentRepository;
import com.Learning.DepartmentProject.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {
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

//    public Student assignDepartmentToStudent(Long studentId, Long departmentId){
//
//        Optional<Student> checkStudent = studentRepository.findById(studentId);
//        if(!checkStudent.isPresent()){ throw new ResourceNotFoundException("Student with id" + studentId + "not found");}
//        Student student = checkStudent.get();
//        Optional<Department> checkDepartment = departmentRepository.findById(departmentId);
//        if(!checkDepartment.isPresent()){ throw new ResourceNotFoundException("Department with id" + studentId + "not found");}
//        Department department = checkDepartment.get();
//
//        student.setDepartment(department);
//        return studentRepository.save(student);
//    }

}
