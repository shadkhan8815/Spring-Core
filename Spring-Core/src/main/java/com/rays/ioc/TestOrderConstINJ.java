package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrderConstINJ {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("OrderConstINJ.xml");
		
		OrderConstINJ order = context.getBean("OrderConstINJ", OrderConstINJ.class);
		
		order.bookATicket(30);
	}

}
