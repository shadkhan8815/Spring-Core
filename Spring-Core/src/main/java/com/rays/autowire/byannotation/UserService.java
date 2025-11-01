package com.rays.autowire.byannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAOInt userDao ;

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}
	
	public void testAdd () {
		
		userDao.add();
	}

}
