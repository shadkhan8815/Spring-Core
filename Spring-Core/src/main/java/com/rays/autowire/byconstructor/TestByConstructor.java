package com.rays.autowire.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByConstructor {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ByConstructor.xml");
		
		UserService service = context.getBean("UserService", UserService.class);
		
		service.testAdd();
	}

}
