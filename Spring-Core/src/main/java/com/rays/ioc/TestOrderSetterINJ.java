package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrderSetterINJ {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("OrderSetterINJ.xml");
		
		OrderSetterINJ order = context.getBean("OrderSetterINJ",OrderSetterINJ.class);
		
		order.bookATicket(25);
	}

}
