package com.ismailekin.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ismailekin.entity.OgrenciBilgi;
import com.ismailekin.entity.SirketBilgisi;


@Repository
public class SirketBilgiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CRUD
	public Long insert(SirketBilgisi sirket) {
		return (Long) sessionFactory.getCurrentSession().save(sirket);
	}

	public void update(SirketBilgisi sirket) {
		sessionFactory.getCurrentSession().update(sirket);
	}

	public void persist(SirketBilgisi sirket) {
		sessionFactory.getCurrentSession().persist(sirket);
	}

	public void delete(SirketBilgisi sirket) {
		sessionFactory.getCurrentSession().delete(sirket);
	}

	public ArrayList<SirketBilgisi> getAll() {
		return (ArrayList<SirketBilgisi>) sessionFactory.getCurrentSession()
				.createQuery("SELECT a FROM SirketBilgisi a order by id desc", SirketBilgisi.class).getResultList();
	}

	public SirketBilgisi getFindById(long id) {		
		return sessionFactory.getCurrentSession().get(SirketBilgisi.class, id);
	}

}
