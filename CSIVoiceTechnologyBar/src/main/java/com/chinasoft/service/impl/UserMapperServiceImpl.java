package com.chinasoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.service.UserMapperService;

@Service
public class UserMapperServiceImpl implements UserMapperService {

	@Autowired
	UserMapper mapper;
    
	public User login(String username, String password) {
		return mapper.selectLogin(username, password);
	} 
	
	public void register(User user) {
		mapper.register(user);
	}
	
	public void voice_register(String username) {
		mapper.voice_register(username);
	}
	
	public void address_register(String username) {
		mapper.address_register(username);
	}
	
	public User selectByUsername(String username) {
	    return mapper.selectByUsername(username);
	}
	
	public void editPassword(String password) {
		mapper.editPassword(password);
	}
	/*
	@Override
	

	public void deleteById(int id) {
		mapper.deleteById(id);
	}

	public void updateByUser(User user) {
		mapper.updateByUser(user);
		
	}
    */


}
