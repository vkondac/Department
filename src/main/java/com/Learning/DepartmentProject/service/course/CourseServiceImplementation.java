package com.Learning.DepartmentProject.service.course;

import com.Learning.DepartmentProject.entity.Course;
import com.Learning.DepartmentProject.entity.Department;
import com.Learning.DepartmentProject.error.course.CourseNotFoundException;
import com.Learning.DepartmentProject.error.department.DepartmentNotFoundException;
import com.Learning.DepartmentProject.repository.CourseRepository;
import com.Learning.DepartmentProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Course course = getCourse(courseId);
        course.setDepartment(getDepartment(departmentId));
        return courseRepository.save(course);
    }
    private Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()) throw new DepartmentNotFoundException("Department with id "+ departmentId + " not found");
        return department.get();
    }
    private Course getCourse(Long courseId) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(courseId);
        if(!course.isPresent()) throw new CourseNotFoundException("Course with id "+ courseId + " not found");
        return course.get();
    }
}
