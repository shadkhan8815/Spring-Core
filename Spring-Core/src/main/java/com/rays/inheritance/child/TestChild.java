package com.rays.inheritance.child;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestChild {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Child.xml");
		
		Employee e = context.getBean("Employee", Employee.class);
		
	    System.out.println("Employee Name: " + e.getName());
	    System.out.println("Employee Age: " + e.getAge());
	    
	    
	}

}
