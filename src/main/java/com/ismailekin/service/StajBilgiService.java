package com.ismailekin.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismailekin.dao.StajBilgiDAO;
import com.ismailekin.entity.StajBilgisi;


@Service
@Transactional
public class StajBilgiService {
	
	@Autowired
	private StajBilgiDAO stajbilgiDAO;

	public Long createStajBilgisi(StajBilgisi staj, HttpServletRequest request) {
		return stajbilgiDAO.insert(staj);
	}
	

	public Long updateStajBilgisi(StajBilgisi staj, HttpServletRequest request) {
		 stajbilgiDAO.update(staj);
		 return 1l;
	}
	
	
	public Long deleteStajBilgisi(StajBilgisi staj, HttpServletRequest request) {
		 stajbilgiDAO.delete(staj);
		 return 1l;
	}
	
	
	
	public ArrayList<StajBilgisi> getAll() {
		return stajbilgiDAO.getAll();
	}


	public StajBilgisi getStajBilgisiFindId(long id) {
		return stajbilgiDAO.getFindById(id);
	}
	
}
