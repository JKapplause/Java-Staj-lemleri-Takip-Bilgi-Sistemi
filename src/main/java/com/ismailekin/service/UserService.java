package com.ismailekin.service;


import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismailekin.dao.UserDAO;

import com.ismailekin.entity.UserA;


@Service
@Transactional
public class UserService {

	@Autowired
	private MailService mailService;
	
	
	@Autowired
	private UserDAO userDAO;

	
	public Long insert(UserA user) {
		String uuid = UUID.randomUUID().toString();
		user.setKeyreg(uuid);
		
		if(userDAO.insert(user)>0) {
			mailService.registerMail(user.getEmail(), user.getKeyreg());
		}
		return 1l;
	}

	public void update(UserA user) {
		userDAO.update(user);
	}

	
	
	
	public UserA getFindByUsernameAndPass(UserA user){
		return userDAO.getFindByUsernameAndPass(user.getUsername(),user.getPassword());
	}
	
	public UserA getFindByUsername(String username){
		return userDAO.getFindByUsername(username);
	}
	
	public boolean getFindByKey(String key) {
		UserA user = (UserA) userDAO.getFindByKey(key);
		 if(user != null) {
			 user.setActive(true);
			 update(user);
			 return true;
		 }else
			 return false;
	}

}














