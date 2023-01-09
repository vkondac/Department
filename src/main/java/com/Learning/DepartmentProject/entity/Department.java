package com.Learning.DepartmentProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @Column(nullable = false)
    @NotBlank(message = "Please Add Department Name")
    @Length(max = 15,min = 1)
    private String departmentName;
    @Column(nullable = false)
    private String departmentAddress;
    @Column(nullable = false)
    private String departmentCode;
    @Column(nullable = false)
    private Integer seatNumber;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    private Set<Course> courses;

}
