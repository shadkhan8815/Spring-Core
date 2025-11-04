package com.rays.dao;

import com.rays.dto.UserDTO;

public interface UserDAOInt {
	
	public long add (UserDTO dto) throws Exception ;
	
	public void update(UserDTO dto);
	
	public void delete (UserDTO dto);
	
	public UserDTO findByLogin(String login);

}
