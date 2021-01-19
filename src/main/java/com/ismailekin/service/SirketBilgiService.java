package com.ismailekin.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismailekin.dao.SirketBilgiDAO;
import com.ismailekin.entity.SirketBilgisi;


@Service
@Transactional
public class SirketBilgiService {
	
	@Autowired
	private SirketBilgiDAO sirketbilgiDAO;

	public Long createSirketBilgisi(SirketBilgisi sirket, HttpServletRequest request) {
		return sirketbilgiDAO.insert(sirket);
	}
	

	public Long updateSirketBilgisi(SirketBilgisi sirket, HttpServletRequest request) {
		 sirketbilgiDAO.update(sirket);
		 return 1l;
	}
	
	
	public Long deleteSirketBilgisi(SirketBilgisi sirket, HttpServletRequest request) {
		 sirketbilgiDAO.delete(sirket);
		 return 1l;
	}
	
	
	
	public ArrayList<SirketBilgisi> getAll() {
		return sirketbilgiDAO.getAll();
	}


	public SirketBilgisi getSirketBilgisiFindId(long id) {
		return sirketbilgiDAO.getFindById(id);
	}
	
}
