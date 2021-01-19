package com.ismailekin.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismailekin.dao.StajDegerlendirmeDAO;
import com.ismailekin.entity.StajDegerlendirme;


@Service
@Transactional
public class StajDegerlendirmeService {
	
	@Autowired
	private StajDegerlendirmeDAO stajdegerlendirmeDAO;

	public Long createStajDegerlendirme(StajDegerlendirme deger, HttpServletRequest request) {
		return stajdegerlendirmeDAO.insert(deger);
	}
	

	public Long updateStajDegerlendirme(StajDegerlendirme deger, HttpServletRequest request) {
		 stajdegerlendirmeDAO.update(deger);
		 return 1l;
	}
	
	
	public Long deleteStajDegerlendirme(StajDegerlendirme deger, HttpServletRequest request) {
		 stajdegerlendirmeDAO.delete(deger);
		 return 1l;
	}
	
	
	
	public ArrayList<StajDegerlendirme> getAll() {
		return stajdegerlendirmeDAO.getAll();
	}


	public StajDegerlendirme getStajDegerlendirmeFindId(long id) {
		return stajdegerlendirmeDAO.getFindById(id);
	}
		
}
