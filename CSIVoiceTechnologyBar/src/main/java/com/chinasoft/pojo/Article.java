package com.chinasoft.pojo;

import java.time.LocalDateTime;

import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Article {
	private int a_id;
	private String essay;
	private String username;
	private String title;
	private LocalDateTime a_createtime;
	private int a_likes;
	private int a_comments;
	private LocalDateTime a_lastcomment;
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getA_createtime() {
		return a_createtime;
	}
	public void setA_createtime(LocalDateTime a_createtime) {
		this.a_createtime = a_createtime;
	}
	public int getA_likes() {
		return a_likes;
	}
	public void setA_likes(int a_likes) {
		this.a_likes = a_likes;
	}
	public int getA_comments() {
		return a_comments;
	}
	public void setA_comments(int a_comments) {
		this.a_comments = a_comments;
	}
	public LocalDateTime getA_lastcomment() {
		return a_lastcomment;
	}
	public void setA_lastcomment(LocalDateTime a_lastcomment) {
		this.a_lastcomment = a_lastcomment;
	}
	public Article(int a_id, String essay, String username, String title, LocalDateTime a_createtime, int a_likes,
			int a_comments, LocalDateTime a_lastcomment) {
		super();
		this.a_id = a_id;
		this.essay = essay;
		this.username = username;
		this.title = title;
		this.a_createtime = a_createtime;
		this.a_likes = a_likes;
		this.a_comments = a_comments;
		this.a_lastcomment = a_lastcomment;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Article [a_id=" + a_id + ", essay=" + essay + ", username=" + username + ", title=" + title
				+ ", a_createtime=" + a_createtime + ", a_likes=" + a_likes + ", a_comments=" + a_comments
				+ ", a_lastcomment=" + a_lastcomment + "]";
	}
	
}
