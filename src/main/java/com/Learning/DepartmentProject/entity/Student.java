package com.Learning.DepartmentProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;
}
