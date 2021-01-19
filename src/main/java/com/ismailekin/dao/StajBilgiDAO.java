package com.ismailekin.dao;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ismailekin.entity.StajBilgisi;


@Repository
public class StajBilgiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CRUD
	public Long insert(StajBilgisi staj) {
		return (Long) sessionFactory.getCurrentSession().save(staj);
	}

	public void update(StajBilgisi staj) {
		sessionFactory.getCurrentSession().update(staj);
	}

	public void persist(StajBilgisi staj) {
		sessionFactory.getCurrentSession().persist(staj);
	}

	public void delete(StajBilgisi staj) {
		sessionFactory.getCurrentSession().delete(staj);
	}

	public ArrayList<StajBilgisi> getAll() {
		return (ArrayList<StajBilgisi>) sessionFactory.getCurrentSession()
				.createQuery("SELECT a FROM StajBilgisi a order by id desc", StajBilgisi.class).getResultList();
	}
	
	public StajBilgisi getFindById(long id) {		
		return sessionFactory.getCurrentSession().get(StajBilgisi.class, id);
	}


}
