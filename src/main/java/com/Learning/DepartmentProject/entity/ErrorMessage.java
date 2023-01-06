package com.Learning.DepartmentProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
