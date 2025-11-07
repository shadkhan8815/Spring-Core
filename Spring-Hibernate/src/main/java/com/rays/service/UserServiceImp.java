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

	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
        return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) {
         return   dao.authenticate(login, password);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> list() {
		return dao.list();
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
