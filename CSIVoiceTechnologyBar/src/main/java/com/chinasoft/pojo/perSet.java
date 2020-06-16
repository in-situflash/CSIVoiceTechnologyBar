package com.chinasoft.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class perSet {
	
	private String username;
	private String email;
	private String password;
	private Date create_time;
	private int age;
	private String Gender;
	private String priviledge;
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
	@DateTimeFormat(pattern="yyyy-MM-dd")
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
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPriviledge() {
		return priviledge;
	}
	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public perSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public perSet(String username, String email, String password, Date
	 * create_time, int age, String gender, String priviledge, int userid) {
	 * super(); this.username = username; this.email = email; this.password =
	 * password; this.create_time = create_time; this.age = age; Gender = gender;
	 * this.priviledge = priviledge; this.userid = userid; }
	 */
	
	
	/*
	 * public perSet(String username, String email, Date create_time, int age,
	 * String gender, int userid) { super(); this.username = username; this.email =
	 * email; this.create_time = create_time; this.age = age; Gender = gender;
	 * this.userid = userid; }
	 */
	
	public perSet(String username, String email, Date create_time, int age, String gender) {
		super();
		this.username = username;
		this.email = email;
		this.create_time = create_time;
		this.age = age;
		Gender = gender;
	}
	
	@Override
	public String toString() {
		return "perSet [username=" + username + ", email=" + email + ", password=" + password + ", create_time="
				+ create_time + ", age=" + age + ", Gender=" + Gender + ", priviledge=" + priviledge + ", userid="
				+ userid + "]";
	}
	
	
	
	
	
	

	
}
