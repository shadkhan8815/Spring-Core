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

	//	test.testAdd();
	//	test.testUpdate();
		test.testDelete();

	}
	
	public void testAdd() {	
	 UserDTO dto = new UserDTO();
	
	        dto.setId(1);
	        dto.setFirstName("Akbar");
	        dto.setLastName("Mansuri");
	        dto.setLogin("akbar@gmail.com");
	        dto.setPassword("1234");
	        
	 long pk = service.add(dto);
	 System.out.println("Data inserted: " + pk);
	}

	public void testUpdate () {
		UserDTO dto = new UserDTO();
		       
		   dto.setFirstName("Amit");
		   dto.setLastName("Kirar");
		   dto.setLogin("amit@gmail.com");
		   dto.setPassword("4321");
		   dto.setId(2);
		   
	       service.update(dto);
	       System.out.println("Data Updated");
	}
	
	public void testDelete() {
		UserDTO dto = new UserDTO();
		
		   dto.setId(2);
		   service.update(dto);
		   System.out.println("Data Deleted");
	}
}
