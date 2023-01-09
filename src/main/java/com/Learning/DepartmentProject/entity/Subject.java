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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectId;
    @Column(name = "name")
    private String subject;
    @Column(name = "subject_year")
    private Integer subjectYear;
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "subject_professor",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private Set<Professor> professors;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;
}
