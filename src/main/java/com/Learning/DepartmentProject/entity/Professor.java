package com.Learning.DepartmentProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long professorId;
    @Column(name = "name")
    @Length(max = 25,min = 1)
    private String fullName;
    @Column(name = "email_address")
    @Email
    private String emailAddress;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @ManyToMany(mappedBy = "professors")
    private Set<Subject> subjects;
}
