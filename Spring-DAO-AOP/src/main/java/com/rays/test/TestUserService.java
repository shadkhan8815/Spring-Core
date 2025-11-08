package com.rays.test;

import java.util.Iterator;
import java.util.List;

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

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testFindByPk();
		// test.testFindByLogin();
		// test.testAuthenticate();
		   test.testSearch();
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

	public void testFindByPk() {

		UserDTO dto = service.findByPk(1);

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Id Does Not Exist..!");
		}
	}

	public void testFindByLogin() {

		UserDTO dto = service.findByLogin("shad@gmail.com");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("E-mail Does Not Exist..!");
		}
	}

	public void testAuthenticate() {

		UserDTO dto = service.authenticate("shad@gmail.com", "root");

		if (dto != null) {

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Invalid LoginId And Password..!");
		}
	}

	public void testSearch() {

		UserDTO dto = new UserDTO();

		List<UserDTO> list = service.search(dto, 0, 0);

		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		}
	}
}
