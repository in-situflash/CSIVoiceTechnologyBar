package com.chinasoft.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.User;
import com.chinasoft.service.impl.UserMapperServiceImpl;

@Controller

public class UserMapperController {
	
	@Autowired
	UserMapperServiceImpl service;
	
	@RequestMapping("/selectLogin")
	public ModelAndView selectLogin(HttpSession session,String username, String password) {
		System.out.println("haha");
		System.out.println(username);
		System.out.println(password);
		ModelAndView mav = new ModelAndView();
		User user = service.login(username, password); 
		if(user != null) {
			System.out.println(user.getUsername());
			session.setAttribute("username", user.getUsername());
			mav.addObject("user", user); 
			mav.setViewName("/WEB-INF/menu.jsp");
		}else {
			mav.setViewName("/index.jsp");
		}
		return mav;
	}
 
	@RequestMapping("/register")
	 public ModelAndView register(User user) {
		    ModelAndView mav = new ModelAndView(); 
	        String username = user.getUsername();
	        int userid = user.getUserid();
	        Random random = new Random();
	        int romdomUserid = random.nextInt(1000);
	        if(romdomUserid != userid) {
	        	user.setUserid(romdomUserid);
	        }
	        // 如果数据库中没有该用户，可以注册，否则跳转页面
	        if (service.selectByUsername(username) == null) {
	        	    service.register(user);
	        		service.voice_register(username);
	        		service.address_register(username);
		        	mav.addObject("user", user);
		            mav.setViewName("/WEB-INF/login.jsp");
	        
	        }
	        
			return mav;       
	}
	
	/*
	@RequestMapping("/editPassword")
	public ModelAndView editPassword(String password){
		 ModelAndView mav = new ModelAndView();
		 String old_password = user.get
		return mav; 
	}*/
	
	 /*
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		System.out.println("Entering userTest...");
		
		return "Success!";
	}
	
		@RequestMapping("/addUserByPar")
	public ModelAndView addUserByPar() {
		ModelAndView mav = new ModelAndView(); 
		User user = new User(0,"username", "password", "gender", "age", "email","create_time","privilege");
		String username=user.getUsername();
		mav.addObject("info", "娣诲姞鎴愬姛");
		mav.setViewName("/index.jsp");
		return mav;
	}
   
	@RequestMapping("/selectById")
	@ResponseBody
	public ModelAndView selectById() {
		ModelAndView mav = new ModelAndView();
		User user = service.selectById(2);
		mav.addObject("user", user);
		mav.setViewName("/index.jsp");
		return mav;
	}
	
	@RequestMapping("/deleteById")
	public ModelAndView deleteById() {
		ModelAndView mav = new ModelAndView();
		service.deleteById(500);
		mav.addObject("info", "鍒犻櫎鎴愬姛");
		mav.setViewName("/index.jsp");
		return mav;
	}
	
	@RequestMapping("/updateByUser")
	public ModelAndView updateByUser() {
		ModelAndView mav = new ModelAndView();
		User user = new User(500, "name", "pwd", "phone", "address", "email", 1);
		service.updateByUser(user);
		mav.addObject("info", "鏇存敼鎴愬姛");
		mav.setViewName("/index.jsp");
		return mav;
	}*/
}
