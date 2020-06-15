package com.chinasoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chinasoft.pojo.User;

public interface UserManageMapper {
	@Delete("delete from user where userid = #{userid}")
	void deleteUserById(int userid);

	@Update("update user set username=#{username},email=#{email}, password=#{password}, age=#{age}, gender=#{gender}, privilege=#{privilege} where userid =#{userid};")
	void updateUserByUser(User user);

	User selectOneUserByPar(int userid);

	void addUsersByPar(User user);
	
	@Select("select * from user")
	List<User>  selectAllUser();
}
