package com.Learning.DepartmentProject.service.course;

import com.Learning.DepartmentProject.entity.Course;
import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.error.CourseNotFoundException;
import com.Learning.DepartmentProject.error.DepartmentNotFoundException;
import com.Learning.DepartmentProject.repository.CourseRepository;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
//    public Course getCourseById()
    public Course assignDepartmentToCourse(Long departmentId, Long courseId) throws DepartmentNotFoundException, CourseNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()) throw new DepartmentNotFoundException("Department with id "+ departmentId + " not found");
        Optional<Course> course = courseRepository.findById(courseId);
        if(!course.isPresent()) throw new CourseNotFoundException("Course with id "+ courseId + " not found");
        course.get().setDepartment(department.get());
        return courseRepository.save(course.get());
    }
}
