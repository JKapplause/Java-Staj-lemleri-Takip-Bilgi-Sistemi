package com.ismailekin.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismailekin.dao.OgrenciBilgiDAO;
import com.ismailekin.entity.OgrenciBilgi;
import com.ismailekin.entity.UserA;

@Service
@Transactional
public class OgrenciBilgiService {
	
	@Autowired
	private OgrenciBilgiDAO ogrencibilgiDAO;

	public Long createOgrenciBilgi(OgrenciBilgi bilgi, HttpServletRequest request) {
		return ogrencibilgiDAO.insert(bilgi);
	}
	

	public Long updateOgrenciBilgi(OgrenciBilgi bilgi, HttpServletRequest request) {
		 ogrencibilgiDAO.update(bilgi);
		 return 1l;
	}
	
	
	public Long deleteOgrenciBilgi(OgrenciBilgi bilgi, HttpServletRequest request) {
		 ogrencibilgiDAO.delete(bilgi);
		 return 1l;
	}
	
	
	
	public ArrayList<OgrenciBilgi> getAll() {
		return ogrencibilgiDAO.getAll();
	}


	public OgrenciBilgi getOgrenciBilgiFindId(long id) {
		return ogrencibilgiDAO.getFindById(id);
	}
		
	public OgrenciBilgi getFindByOgrenciId(long id) {
		return ogrencibilgiDAO.getByOgrenciId(id);
	}
	
	
	public OgrenciBilgi getFindByUsernameAndPass(OgrenciBilgi ogrenci){
		return ogrencibilgiDAO.getFindByUsernameAndPass(ogrenci.getOgrenci_no(),ogrenci.getSifre());
	}
	
}
