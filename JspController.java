package com.chinasoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.perSet;
import com.chinasoft.service.impl.UserMapperServiceImpl;
import com.chinasoft.service.impl.perSetMapperServiceImpl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/jsp")
public class JspController{
	@Autowired
	perSetMapperServiceImpl service;
	
	@RequestMapping(value = "/perSetGet",method = RequestMethod.GET)
	public String method01() throws Exception {
		System.out.println("跳转到perSet.jsp, 显示个人设置页面");
		//return "jsp";
		return "/WEB-INF/perSet.jsp";
	}
	
	
	//个人设置表单数据的提交
	@RequestMapping(value = "/perSetPost",method = RequestMethod.POST)
	public ModelAndView method02 (HttpServletRequest request, MultipartFile file/*String username*/,String regSex,int userage,String userEmail, Model model) throws Exception {
		//ModelAndView
		//httpsession得到登陆用户名
		HttpSession session=request.getSession();
		String username= (String) session.getAttribute("username");
		System.out.println("文件提交的内容进来了");
		//return "jsp";
		System.out.println("打印表单数据：\n");
		//System.out.println("username: "+username+"\n");
		
		System.out.println("username: "+username+"\n");
		regSex=request.getParameter("regSex");
		System.out.println("Sex: "+regSex+"\n");
		
		
		System.out.println("userAge: "+userage+"\n");
		System.out.println("userEmail: "+userEmail+"\n");
		System.out.println("头像文件信息：");
		System.out.println(file.getOriginalFilename()+"\n");
		//System.out.println("userAge: "+userage+"\n");
		model.addAttribute("Filename", "lenna");
		//return "down";
		
		//把表单提交的参数传进数据库
		//ModelAndView mav = new ModelAndView();
		/*
		 * Date date=new Date(); perSet per = new
		 * perSet(username,userEmail,"1",date,userage,regSex,"普通权限",4);
		 * service.InsertByPerSet(per); //mav.addObject("info", "信息");
		 * //mav.setViewName("/WEB-INF/menu.jsp"); return "/WEB-INF/menu.jsp";
		 */
		ModelAndView mav = new ModelAndView();
		Date date=new Date();
		perSet per=new perSet("张三",userEmail,date,userage,regSex);
		service.updateByPerSet(per);
		mav.setViewName("/WEB-INF/menu.jsp");
		return mav;
		
	}
	
	
	
	
	/*
	 * @RequestMapping("/perSet2") public String process() {
	 * System.out.println(input); return "/WEB-INF/login.jsp"; }
	 */
	
}
