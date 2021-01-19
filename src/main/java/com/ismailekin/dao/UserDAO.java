package com.ismailekin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.catalina.User;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ismailekin.entity.OgrenciBilgi;
import com.ismailekin.entity.UserA;


@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CRUD
	public Long insert(UserA user) {
		return (Long) sessionFactory.getCurrentSession().save(user);
	}

	public void update(UserA user) {
		sessionFactory.getCurrentSession().update(user);
	}	
	
	public UserA getFindByUsernameAndPass(String username,String pass) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserA WHERE username=:username AND password=:pass AND active=:active")
				.setBoolean("active", true)
				.setString("username", username)
				.setString("pass", pass);
				UserA user = null;
				try{
					user = (UserA) query.getSingleResult();
				}catch (javax.persistence.NoResultException e) {
					user = null;
				}
				return user;

	}

	public UserA getFindByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserA WHERE username=:username")
				.setString("username", username);
		return (UserA) query.getSingleResult();
	}

	
	public UserA getFindByKey(String key) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserA WHERE keyreg=:key")
				.setString("key", key);
		UserA user = null;
		try {
			user = (UserA) query.getSingleResult();
		}catch (javax.persistence.NoResultException e) {
			user =null;
		}
		return user;
		
	}
}














