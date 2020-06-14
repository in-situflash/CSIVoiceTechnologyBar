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
		System.out.println("��ת��perSet.jsp, ��ʾ��������ҳ��");
		//return "jsp";
		return "/WEB-INF/perSet.jsp";
	}
	
	
	//�������ñ����ݵ��ύ
	@RequestMapping(value = "/perSetPost",method = RequestMethod.POST)
	public ModelAndView method02 (HttpServletRequest request, MultipartFile file/*String username*/,String regSex,int userage,String userEmail, Model model) throws Exception {
		//ModelAndView
		//httpsession�õ���½�û���
		HttpSession session=request.getSession();
		String username= (String) session.getAttribute("username");
		System.out.println("�ļ��ύ�����ݽ�����");
		//return "jsp";
		System.out.println("��ӡ�����ݣ�\n");
		//System.out.println("username: "+username+"\n");
		
		System.out.println("username: "+username+"\n");
		regSex=request.getParameter("regSex");
		System.out.println("Sex: "+regSex+"\n");
		
		
		System.out.println("userAge: "+userage+"\n");
		System.out.println("userEmail: "+userEmail+"\n");
		System.out.println("ͷ���ļ���Ϣ��");
		System.out.println(file.getOriginalFilename()+"\n");
		//System.out.println("userAge: "+userage+"\n");
		model.addAttribute("Filename", "lenna");
		//return "down";
		
		//�ѱ��ύ�Ĳ����������ݿ�
		//ModelAndView mav = new ModelAndView();
		/*
		 * Date date=new Date(); perSet per = new
		 * perSet(username,userEmail,"1",date,userage,regSex,"��ͨȨ��",4);
		 * service.InsertByPerSet(per); //mav.addObject("info", "��Ϣ");
		 * //mav.setViewName("/WEB-INF/menu.jsp"); return "/WEB-INF/menu.jsp";
		 */
		ModelAndView mav = new ModelAndView();
		Date date=new Date();
		perSet per=new perSet("����",userEmail,date,userage,regSex);
		service.updateByPerSet(per);
		mav.setViewName("/WEB-INF/menu.jsp");
		return mav;
		
	}
	
	
	
	
	/*
	 * @RequestMapping("/perSet2") public String process() {
	 * System.out.println(input); return "/WEB-INF/login.jsp"; }
	 */
	
}
