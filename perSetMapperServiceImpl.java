package com.chinasoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.chinasoft.perSetmapper.Mapper;
import com.chinasoft.mapper.perSetMapper;
import com.chinasoft.pojo.User;
//import com.chinasoft.pojo.User;
import com.chinasoft.pojo.perSet;
import com.chinasoft.service.perSetMapperService;

@Service
public class perSetMapperServiceImpl implements perSetMapperService {
	@Autowired
	perSetMapper mapper;

	@Override
	public void InsertByPerSet(perSet per) {
		mapper.addPerSetByPar(per);
	}
	public void updateByPerSet(perSet per) {
		mapper.updateByPerSet(per);
		
	}
}
