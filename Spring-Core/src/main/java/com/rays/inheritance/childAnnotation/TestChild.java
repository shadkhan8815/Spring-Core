package com.rays.inheritance.childAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestChild {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Person e = context.getBean("person", Person.class);

		System.out.println(e.getName());
		System.out.println(e.getAge());
	}

}
