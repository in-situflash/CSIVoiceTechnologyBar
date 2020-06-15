package com.chinasoft.service;

import com.chinasoft.pojo.User;

public interface UserManageMapperService {
	User selectUserById(int id);
	
	void InsertUserByUser(User user);
	
	void deleteUserById(int id);
	
	void updateUserByUser(User user);
	
}
