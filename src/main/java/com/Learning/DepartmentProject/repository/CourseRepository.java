package com.Learning.DepartmentProject.repository;

import com.Learning.DepartmentProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByCourseNameStartsWith(String startingLetter);
}
