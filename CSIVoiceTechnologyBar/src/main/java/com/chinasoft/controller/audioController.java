package com.chinasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.audioSet;
import com.chinasoft.service.impl.audioSetMapperServiceImpl;
//import com.chinasoft.service.impl.perSetMapperServiceImpl;

//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/audio")
public class audioController{
	@Autowired
	audioSetMapperServiceImpl service;
	
	@RequestMapping(value = "/audioSetGet",method = RequestMethod.GET)
	public String audioSetGet() throws Exception {
		System.out.println("跳转到audioSet.jsp, 显示个人设置页面");
		//return "jsp";
		return "/WEB-INF/audioSet.jsp";
	}
	
	
	//语音设置表单数据的提交
	@RequestMapping(value = "/audioSetPost",method = RequestMethod.POST)
	public ModelAndView audioSetPost (HttpSession session,HttpServletRequest request, String auSetVoiPer,String auSetSpd,String auSetPit,String auSetVol, Model model) throws Exception {
		//ModelAndView
		
		//httpsession得到登陆用户名
		Object usernameobj = session.getAttribute("username");
		String username = usernameobj.toString();
		
		System.out.println("语音设置文件提交的内容进来了");
		//return "jsp";
		System.out.println("打印表单数据：\n");
		//System.out.println("username: "+username+"\n");
		
		auSetVoiPer=request.getParameter("auSetVoiPer");
		System.out.println("auSetVoiPer(发声人): "+auSetVoiPer+"\n");
		/*
		 * if(auSetVoiPer==(""+'0')) auSetVoiPer="普通男声"; else if(auSetVoiPer==(""+'1'))
		 * auSetVoiPer=""
		 */
		
		//对应option，转化为string，以便插入数据库
		switch (auSetVoiPer) {
		case ""+'0':
			auSetVoiPer = "普通女声";
			break;
		case ""+'1':
			auSetVoiPer = "普通男声";
			break;
		case ""+'2':
			auSetVoiPer = "度逍遥（武侠）";
			break;
		case ""+'3':
			auSetVoiPer = "度丫丫（软萌）";
			break;
		default:
			break;
		}
			
		
		auSetSpd=request.getParameter("auSetSpd");
		System.out.println("auSetSpd(语速): "+auSetSpd+"\n");
		
		auSetPit=request.getParameter("auSetPit");
		System.out.println("auSetPit(音调): "+auSetPit+"\n");
		
		auSetVol=request.getParameter("auSetVol");
		System.out.println("auSetVol(音量): "+auSetVol+"\n");
		
		//语速、音调、音量转换为int，数据库中为int
		int speed = Integer.parseInt(auSetSpd);
		int tone = Integer.parseInt(auSetPit);
		int volume = Integer.parseInt(auSetVol);
		
		
		
		ModelAndView mav = new ModelAndView();
		//Date date=new Date();
		audioSet audio =new audioSet(username,auSetVoiPer,speed,tone,volume);
		service.updateByAudioSet(audio);
		mav.setViewName("/WEB-INF/menu.jsp");
		return mav;
		
	}
		
	}