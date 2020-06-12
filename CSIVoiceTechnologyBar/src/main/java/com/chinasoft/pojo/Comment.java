package com.chinasoft.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment {
	private int c_id;						//评论id
	private String content;					//评论内容
	private String username;     			//评论用户名
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date c_createtime;				//评论时间
	private int a_id; 						//对应文章id
	private int c_likes;					//评论点赞数
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getC_createtime() {
		return c_createtime;
	}
	public void setC_createtime(Date c_createtime) {
		this.c_createtime = c_createtime;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public int getC_likes() {
		return c_likes;
	}
	public void setC_likes(int c_likes) {
		this.c_likes = c_likes;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int c_id, String content, String username, Date c_createtime, int a_id, int c_likes) {
		super();
		this.c_id = c_id;
		this.content = content;
		this.username = username;
		this.c_createtime = c_createtime;
		this.a_id = a_id;
		this.c_likes = c_likes;
	}
	@Override
	public String toString() {
		return "Comment [c_id=" + c_id + ", content=" + content + ", username=" + username + ", c_createtime="
				+ c_createtime + ", a_id=" + a_id + ", c_likes=" + c_likes + "]";
	}
	
	
}
