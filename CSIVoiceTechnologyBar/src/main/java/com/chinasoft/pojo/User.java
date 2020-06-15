package com.chinasoft.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User  implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;
	@JsonFormat(pattern = "yyyy:MM:dd hh:mm:ss",timezone = "GMT+8")
	private Date create_time;
	private int age;
	private String gender;
	private String privilege;
	private int userid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Date getCreate_time() {
		return create_time;
	}
	
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String email, String password, Date create_time, int age, String gender,
			String privilege, int userid) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.create_time = create_time;
		this.age = age;
		this.gender = gender;
		this.privilege = privilege;
		this.userid = userid;
	}
	
	public User(String username, String email, String password, int age, String gender, String privilege, int userid) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.privilege = privilege;
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", create_time="
				+ create_time + ", age=" + age + ", gender=" + gender + ", privilege=" + privilege + ", userid="
				+ userid + "]";
	}
	
	
	
	
}
