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

	@Override
	public User selectById(int id) {
		User user = mapper.selectOneByPar(id);
		return user;
	}

	public void InsertByUser(User user) {
		mapper.addUserByPar(user);
	}

	public void deleteById(int id) {
		mapper.deleteById(id);
	}

	public void updateByUser(User user) {
		mapper.updateByUser(user);
		
	}



}
