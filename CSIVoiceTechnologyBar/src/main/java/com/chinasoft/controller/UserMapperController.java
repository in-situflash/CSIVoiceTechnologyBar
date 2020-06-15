package com.chinasoft.controller;

import java.util.Date;

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
  
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		System.out.println("Entering userTest...");
		
		return "Success!";
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
	
	@RequestMapping("/insertByUser")
	public ModelAndView InsertByUser() {
		ModelAndView mav = new ModelAndView();
		User user = new User("username","email", "password",new Date(), 2, "男", "普通用户", 4);
		service.InsertByUser(user);
		mav.addObject("info", "娣诲姞鎴愬姛");
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
		User user =  new User("username","email", "password",new Date(), 2, "男", "普通用户", 2);
		service.updateByUser(user);
		mav.addObject("info", "鏇存敼鎴愬姛");
		mav.setViewName("/index.jsp");
		return mav;
	}
}
