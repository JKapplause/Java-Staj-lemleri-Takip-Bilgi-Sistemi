package com.ismailekin.dao;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ismailekin.entity.StajDegerlendirme;


@Repository
public class StajDegerlendirmeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CRUD
	public Long insert(StajDegerlendirme deger) {
		return (Long) sessionFactory.getCurrentSession().save(deger);
	}

	public void update(StajDegerlendirme deger) {
		sessionFactory.getCurrentSession().update(deger);
	}

	public void persist(StajDegerlendirme deger) {
		sessionFactory.getCurrentSession().persist(deger);
	}

	public void delete(StajDegerlendirme deger) {
		sessionFactory.getCurrentSession().delete(deger);
	}

	public ArrayList<StajDegerlendirme> getAll() {
		return (ArrayList<StajDegerlendirme>) sessionFactory.getCurrentSession()
				.createQuery("SELECT a FROM StajDegerlendirme a order by id desc", StajDegerlendirme.class).getResultList();
	}
	
	public StajDegerlendirme getFindById(long id) {		
		return sessionFactory.getCurrentSession().get(StajDegerlendirme.class, id);
	}


}
