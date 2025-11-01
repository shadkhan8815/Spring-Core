package com.rays.inheritance.childAnnotation;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component("employee")
public class Employee extends Person {

	@PostConstruct
	public void initialize() {

		System.out.println("Initializing Employee..!");
	}

}
