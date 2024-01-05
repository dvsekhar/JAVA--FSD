package com.users.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.users.entity.UsersEntity;

@Repository
@Transactional
public class UsersDAO {
	
	JdbcTemplate template;  
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<UsersEntity> getAllUsers() {
		return this.sessionFactory.getCurrentSession().createQuery("from UsersEntity").list();
	}
	
	 public UsersEntity getUserById(int id) {
	        return (UsersEntity) sessionFactory.getCurrentSession().get(UsersEntity.class, id);
	    }
	 
	 public void update(UsersEntity user) {
		    sessionFactory.getCurrentSession().update(user);
		}

	public void save(UsersEntity newUser) {
		sessionFactory.getCurrentSession().save(newUser);
		
	}

}
