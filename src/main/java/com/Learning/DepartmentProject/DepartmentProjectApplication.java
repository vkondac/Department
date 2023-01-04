package com.Learning.DepartmentProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentProjectApplication {
	Logger logger = LoggerFactory.getLogger(DepartmentProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DepartmentProjectApplication.class, args);
	}

}
