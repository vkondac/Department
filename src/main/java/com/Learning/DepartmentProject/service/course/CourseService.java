package com.Learning.DepartmentProject.service.course;

import com.Learning.DepartmentProject.entity.Course;
import com.Learning.DepartmentProject.error.course.CourseNotFoundException;
import com.Learning.DepartmentProject.error.department.DepartmentNotFoundException;

public interface CourseService {
    public Course saveCourse(Course course);
    public Course assignDepartmentToCourse(Long departmentId, Long courseId) throws DepartmentNotFoundException, CourseNotFoundException;
}
