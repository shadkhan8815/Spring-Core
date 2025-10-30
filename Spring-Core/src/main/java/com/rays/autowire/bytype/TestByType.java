package com.rays.autowire.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByType {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ByType.xml");
		
		UserService service = context.getBean("UserService", UserService.class);
		
		service.testAdd();
	}

}
