package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOImp implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) throws Exception {

		UserDTO existLogin = findByLogin(dto.getLogin());

		if (existLogin != null) {

			throw new Exception("Duplicate Record Exception :-> " + " Email Id Already Exist");

		}

		String sql = "insert into st_user values(?,?,?,?,?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());

		return pk;
	}

	public void update(UserDTO dto) {

		String sql = "update st_user set firstName = ?, lastName = ?, login = ?, password = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		System.out.println("Data Updated: " + i);

	}

	public void delete(UserDTO dto) {

		String sql = "delete from st_user where id = ?";

		int i = jdbcTemplate.update(sql, dto.getId());

		System.out.println("Data Deleted: " + i);
	}

	public UserDTO findByLogin(String login) {

		UserDTO user = null;

		try {
			String sql = "select * from st_user where login = ?";

			Object[] param = { login };

			user = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}

	public UserDTO authenticate(String login, String password) {

		UserDTO user = null;

		try {
			String sql = "select * from st_user where login = ? and password = ?";

			Object[] param = { login, password };

			user = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}

	public List<UserDTO> list() {

		return search(null);
	}

	public List<UserDTO> search(UserDTO dto) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");

		if (dto != null) {
			
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + dto.getFirstName() + "%'");
			}
			
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				sql.append(" and lastName like '" + dto.getLastName() + "%'");
			}
			
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				sql.append(" and login like '" + dto.getLogin() + "%'");
			}
			
		}

		List list = jdbcTemplate.query(sql.toString(), new UserMapper());

		return list;

	}
}
