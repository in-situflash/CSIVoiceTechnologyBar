package com.chinasoft.pojo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ArticleDetail {
	private int a_id;								  //文章id
	private String title;							  //标题
	private String essay;							  //文章内容
	private String username;						  //发帖人用户名
	private Date a_createtime;                        //发帖时间
	private Date create_time;                         //发帖人注册时间
	private int a_likes;                              //点赞数
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getA_createtime() {
		return a_createtime;
	}
	public void setA_createtime(Date a_createtime) {
		this.a_createtime = a_createtime;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getA_likes() {
		return a_likes;
	}
	public void setA_likes(int a_likes) {
		this.a_likes = a_likes;
	}
	public ArticleDetail(int a_id, String title, String essay, String username, Date a_createtime, Date create_time,
			int a_likes) {
		super();
		this.a_id = a_id;
		this.title = title;
		this.essay = essay;
		this.username = username;
		this.a_createtime = a_createtime;
		this.create_time = create_time;
		this.a_likes = a_likes;
	}
	public ArticleDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ArticleDetail [a_id=" + a_id + ", title=" + title + ", essay=" + essay + ", username=" + username
				+ ", a_createtime=" + a_createtime + ", create_time=" + create_time + ", a_likes=" + a_likes + "]";
	}
	
	
}
