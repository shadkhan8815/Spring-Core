package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		//test.testAdd();
		//test.testUpdate();
		test.testDelete();
	}

	public void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("Akbar");
		dto.setLastName("Mansuri");
		dto.setLogin("akbar@gmail.com");
		dto.setPassword("root");

		long pk = service.add(dto);
		System.out.println("data added successfully: " + pk);
	}
	
	public void testUpdate() {
		
		UserDTO dto = new UserDTO();
		
		dto.setId(1);
		dto.setFirstName("Chetan");
		dto.setLastName("Patidar");
		dto.setLogin("chetan@gmail.com");
		dto.setPassword("root");
		 
		service.update(dto);
	}
	
	public void testDelete() {
		
		UserDTO dto = new UserDTO();
		
		dto.setId(2);
		service.delete(dto);
	}

}