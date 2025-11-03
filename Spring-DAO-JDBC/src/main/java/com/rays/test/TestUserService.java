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
	public UserServiceInt service = null;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TestUserService test = context.getBean("testUserService", TestUserService.class);

		test.testAdd();

	}
	
	public void testAdd() {
		
	UserDTO dto = new UserDTO();
	
	        dto.setId(2);
	        dto.setFirstName("Akbar");
	        dto.setLastName("Mansuri");
	        dto.setLogin("akbar@gmail.com");
	        dto.setPassword("1234");
	        
	 long pk = service.add(dto);
	 System.out.println("Data inserted: " + pk);
	}

}
