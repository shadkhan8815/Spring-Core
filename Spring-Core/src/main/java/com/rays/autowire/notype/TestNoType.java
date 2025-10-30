package com.rays.autowire.notype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNoType {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("NoType.xml");
		
		UserService service = context.getBean("UserService", UserService.class);
		
		service.testAdd();
	}

}
