package com.chinasoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.UserManageMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.service.UserManageMapperService;

@Service
public class UserManageMapperServiceImpl implements UserManageMapperService {

	@Autowired
	UserManageMapper mapper;
	
	@Override
	public User selectUserById(int userid) {
		User user = mapper.selectOneUserByPar(userid);
		return user;
	}

	@Override
	public void InsertUserByUser(User user) {
		mapper.addUsersByPar(user);
		
	}

	@Override
	public void deleteUserById(int userid) {
		mapper.deleteUserById(userid);
		
	}

	@Override
	public void updateUserByUser(User user) {
		mapper.updateUserByUser(user);
		
	}

	public List<User> queryAllUser() {
		List<User> list= mapper.selectAllUser();
		return list;
	}
	
	public User queryOneUser(String username) {
		User user=mapper.selectUsersByUsername(username);
		return user;
	}

}
