package com.rays.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Person p = context.getBean(Person.class);

		System.out.println(p.getName());
		System.out.println(p.getAddress());
	}

}
