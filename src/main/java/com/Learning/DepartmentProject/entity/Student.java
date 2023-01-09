package com.Learning.DepartmentProject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @Column(name = "first_name")
    @NotBlank(message = "please enter first name")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "please enter second name")
    private String lastName;
    @Column(name = "mail_adress")
    @NotBlank(message = "please enter email")
    @Email
    private String email;
    @Column(name = "is_enrolled")
    @NotNull
    private Boolean isEnrolled;
    @Column(name = "enrolled_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrolledDate;
    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects;
}
