package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOHibernateImp;
import com.rays.dao.UserDAOInt;
import com.rays.dao.UserDAOJDBCImp;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImp implements UserServiceInt {
	
	@Autowired
	private UserDAOHibernateImp hibernateDAO ;
	
	@Autowired
	private UserDAOJDBCImp jdbcDAO ;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) throws Exception {
		return hibernateDAO.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		jdbcDAO.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		hibernateDAO.delete(dto);
	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
        return jdbcDAO.findByPk(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		return hibernateDAO.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) {
         return   jdbcDAO.authenticate(login, password);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> list() {
		return hibernateDAO.list();
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return jdbcDAO.search(dto, pageNo, pageSize);
	}

}
