package com.Learning.DepartmentProject.service.student;

import com.Learning.DepartmentProject.entity.Student;
import com.Learning.DepartmentProject.entity.Subject;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import com.Learning.DepartmentProject.repository.StudentRepository;
import com.Learning.DepartmentProject.repository.SubjectRepository;
import com.Learning.DepartmentProject.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    public Student getStudentById(Long studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent()){
            throw new ResourceNotFoundException("Student not found");
        }
        return student.get();
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Student assignSubjectsToStudent(Long subjectId, Long studentId){
        Student student = getStudentById(studentId);
        Set<Subject> subjectSet = student.getSubjects();
        subjectSet.add(getSubject(subjectId));
        student.setSubjects(subjectSet);
        return studentRepository.save(student);
    }

    private Subject getSubject(Long subjectId){
        return subjectRepository.findById(subjectId).get();
    }

}
