package com.chinasoft.service;

import com.chinasoft.pojo.User;

public interface UserMapperService {

	User login(String username, String password);
	
	void register(User user);
	
	void voice_register(String username);
	
	void address_register(String username);
	
	User selectByUsername(String username);
	
	void editPassword(String password);
	/*
	

	void deleteById(int id);
	
	void updateByUser(User user);
	*/
	
	
}
