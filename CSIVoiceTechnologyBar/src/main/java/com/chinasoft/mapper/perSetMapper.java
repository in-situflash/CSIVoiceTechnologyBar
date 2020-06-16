package com.chinasoft.mapper;

import org.apache.ibatis.annotations.Update;

import com.chinasoft.pojo.User;
import com.chinasoft.pojo.perSet;

public interface perSetMapper {

	//本来应该是update，但现在用insert测试
	
	void addPerSetByPar(perSet per);
	
	//更新数据库
	@Update("update user set email=#{email},create_time=#{create_time},age=#{age},gender=#{gender} where username =#{username};")
	void updateByPerSet(perSet per);
	
}
