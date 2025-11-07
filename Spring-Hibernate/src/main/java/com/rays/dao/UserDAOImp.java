package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOImp implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		long pk = (Long) session.save(dto);
		return pk;
	}

	public void update(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		session.update(dto);
	}

	public void delete(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
	}

	public UserDTO findByPk(long id) {

		Session session = sessionFactory.getCurrentSession();
        UserDTO user = session.get(UserDTO.class, id);
		return user;
	}

	public UserDTO findByLogin(String login) {
		
		List<UserDTO> list = null ;
		UserDTO user = null ;
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		list = criteria.list();
		
		if (list.size() == 1) {
			user = (UserDTO)list.get(0);
		}
		return user;
	}

	public UserDTO authenticate(String login, String password) {
		
		List<UserDTO> list = null ;
		UserDTO user = null ;
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		list = criteria.list();
		
		if (list.size() == 1) {
			user = (UserDTO)list.get(0);
		}
		return user;
	}

	public List<UserDTO> list() {
		return search(null, 0, 0);
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		
		List<UserDTO> list = null ;
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		
		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()));
			}
		}
		
		if (pageSize > 0) {
			pageNo =(pageNo - 1)* pageSize ;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list = criteria.list();
		return list;
	}

}
