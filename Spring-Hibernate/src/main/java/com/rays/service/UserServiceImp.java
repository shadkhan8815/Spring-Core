package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImp implements UserServiceInt {
	
	@Autowired
	private UserDAOInt dao ;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
        dao.delete(dto);
	}

	public UserDTO findByPk(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
