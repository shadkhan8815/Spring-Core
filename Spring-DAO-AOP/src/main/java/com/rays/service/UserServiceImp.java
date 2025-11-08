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

	public long add(UserDTO dto) {
		return dao.add(dto);
	}

	public void update(UserDTO dto) {
		dao.update(dto);
	}

	public void delete(UserDTO dto) {
        dao.delete(dto);
	}

	public UserDTO findByPk(long id) {
        return dao.findByPk(id);
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {
         return   dao.authenticate(login, password);
	}

	public List<UserDTO> list() {
		return dao.list();
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
