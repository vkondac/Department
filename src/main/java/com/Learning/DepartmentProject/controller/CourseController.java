package com.Learning.DepartmentProject.controller;

import com.Learning.DepartmentProject.entity.Course;
import com.Learning.DepartmentProject.error.CourseNotFoundException;
import com.Learning.DepartmentProject.error.DepartmentNotFoundException;
import com.Learning.DepartmentProject.service.course.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }
    @PutMapping("/courses/{courseId}/departments/{departmentId}")
    public Course assignDepartmentToCourse(@PathVariable("departmentId") Long departmentId,@PathVariable(name = "courseId") Long courseId) throws DepartmentNotFoundException, CourseNotFoundException {
        return courseService.assignDepartmentToCourse(departmentId,courseId);
    }
}
