package com.rays.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByName {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ByName.xml");
		
		UserService service = context.getBean("UserService", UserService.class);
		
		service.testAdd();
	}

}
