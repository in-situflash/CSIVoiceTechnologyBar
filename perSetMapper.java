package com.chinasoft.mapper;

import org.apache.ibatis.annotations.Update;

import com.chinasoft.pojo.User;
import com.chinasoft.pojo.perSet;

public interface perSetMapper {

	//����Ӧ����update����������insert����
	
	void addPerSetByPar(perSet per);
	
	//�������ݿ�
	@Update("update user set email=#{email},create_time=#{create_time},age=#{age},gender=#{gender} where username =#{username};")
	void updateByPerSet(perSet per);
	
}
