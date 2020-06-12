package com.chinasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.User;
import com.chinasoft.service.impl.UserMapperServiceImpl;

@Controller
@RequestMapping("/user")
public class UserMapperController {

	@Autowired
	UserMapperServiceImpl service;
	
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
		User user = new User(500, "username", "password", "phone", "address", "email", 1);
		service.InsertByUser(user);
		mav.addObject("info", "添加成功");
		mav.setViewName("/index.jsp");
		return mav;
	}
	
	@RequestMapping("/deleteById")
	public ModelAndView deleteById() {
		ModelAndView mav = new ModelAndView();
		service.deleteById(500);
		mav.addObject("info", "删除成功");
		mav.setViewName("/index.jsp");
		return mav;
	}
	
	@RequestMapping("/updateByUser")
	public ModelAndView updateByUser() {
		ModelAndView mav = new ModelAndView();
		User user = new User(500, "name", "pwd", "phone", "address", "email", 1);
		service.updateByUser(user);
		mav.addObject("info", "更改成功");
		mav.setViewName("/index.jsp");
		return mav;
	}
}
