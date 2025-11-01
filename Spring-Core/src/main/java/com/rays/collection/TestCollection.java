package com.rays.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {
	
	public static void main(String[] args) {
		 
		ApplicationContext context = new ClassPathXmlApplicationContext("Collection.xml");
		
//		MyListBean list = context.getBean("MyListBean", MyListBean.class);
//		list.displayData();
		
		MySetBean set = context.getBean("MySetBean", MySetBean.class);
		set.displayData();
	}

}
