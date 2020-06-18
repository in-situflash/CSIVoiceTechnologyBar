package com.chinasoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chinasoft.pojo.User;

public interface UserMapper {
	
	User selectLogin(@Param("username")String username,@Param("password")String password);
	
	void register(User user);
	
	void voice_register(String username);
	
	void address_register(String username);
	
	User selectByUsername(String username);
	
	void editPassword(String password);
	/*
	void addUserNoPar();
	
	@Select("select * from user")
	List<User>  selectAll();
	
	User selectLogin(User user);
	
	List<User> selectOrderBy(@Param("column")String column);
	
	User findUserWith_if(User user);
	
	List<User>  findUsersWithList(List<Integer> list);

	@Delete("delete from user where id = #{id}")
	void deleteById(int id);

	@Update("update user set username=#{username}, password=#{password}, phone=#{phone}, address=#{address}, email=#{email}, c_id=#{c_id} where id =#{id};")
	void updateByUser(User user);
    */
	
}
