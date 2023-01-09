package com.Learning.DepartmentProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    @Column(name = "course_name")
    private String courseName;
    @JsonIgnore
    @ManyToOne
    private Department department;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course")
    private Set<Subject> subjects;
}
