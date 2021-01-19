package com.ismailekin.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ismailekin.entity.OgrenciBilgi;
import com.ismailekin.entity.UserA;


@Repository
public class OgrenciBilgiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CRUD
	public Long insert(OgrenciBilgi bilgi) {
		return (Long) sessionFactory.getCurrentSession().save(bilgi);
	}

	public void update(OgrenciBilgi bilgi) {
		sessionFactory.getCurrentSession().update(bilgi);
	}

	public void persist(OgrenciBilgi bilgi) {
		sessionFactory.getCurrentSession().persist(bilgi);
	}

	public void delete(OgrenciBilgi bilgi) {
		sessionFactory.getCurrentSession().delete(bilgi);
	}

	public ArrayList<OgrenciBilgi> getAll() {
		return (ArrayList<OgrenciBilgi>) sessionFactory.getCurrentSession()
				.createQuery("SELECT a FROM OgrenciBilgi a order by id desc", OgrenciBilgi.class).getResultList();
	}
	
	public OgrenciBilgi getFindById(long id) {		
		return sessionFactory.getCurrentSession().get(OgrenciBilgi.class, id);
	}
	

	public OgrenciBilgi getByOgrenciId(long id) {		
		return sessionFactory.getCurrentSession().get(OgrenciBilgi.class, id);
	}
	
	public OgrenciBilgi getFindByUsernameAndPass(int ogrenciNo, String pass) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM OgrenciBilgi WHERE ogrenci_no=:ogrenciNo AND sifre=:pass")
				.setInteger("ogrenciNo", ogrenciNo)
				.setString("pass", pass);
				OgrenciBilgi ogrenci = null;
				try{
					ogrenci = (OgrenciBilgi) query.getSingleResult();
				}catch (javax.persistence.NoResultException e) {
					ogrenci = null;
				}
				return ogrenci;

	}
}
