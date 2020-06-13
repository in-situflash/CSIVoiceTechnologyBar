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
		System.out.println("��ת��audioSet.jsp, ��ʾ��������ҳ��");
		//return "jsp";
		return "/WEB-INF/audioSet.jsp";
	}
	
	
	//�������ñ����ݵ��ύ
	@RequestMapping(value = "/audioSetPost",method = RequestMethod.POST)
	public ModelAndView audioSetPost (HttpServletRequest request, String auSetVoiPer,String auSetSpd,String auSetPit,String auSetVol, Model model) throws Exception {
		//ModelAndView
		
		//httpsession�õ���½�û���
		HttpSession session=request.getSession();
		String username= (String) session.getAttribute("username");
		
		System.out.println("���������ļ��ύ�����ݽ�����");
		//return "jsp";
		System.out.println("��ӡ�����ݣ�\n");
		//System.out.println("username: "+username+"\n");
		
		auSetVoiPer=request.getParameter("auSetVoiPer");
		System.out.println("auSetVoiPer(������): "+auSetVoiPer+"\n");
		/*
		 * if(auSetVoiPer==(""+'0')) auSetVoiPer="��ͨ����"; else if(auSetVoiPer==(""+'1'))
		 * auSetVoiPer=""
		 */
		switch (auSetVoiPer) {
		case ""+'0':
			auSetVoiPer = "��ͨ����";
			break;
		case ""+'1':
			auSetVoiPer = "��ͨŮ��";
			break;
		case ""+'2':
			auSetVoiPer = "����ң��������";
			break;
		case ""+'3':
			auSetVoiPer = "��ѾѾ�����ȣ�";
			break;
		default:
			break;
		}
			
		
		auSetSpd=request.getParameter("auSetSpd");
		System.out.println("auSetSpd(����): "+auSetSpd+"\n");
		
		auSetPit=request.getParameter("auSetPit");
		System.out.println("auSetPit(����): "+auSetPit+"\n");
		
		auSetVol=request.getParameter("auSetVol");
		System.out.println("auSetVol(����): "+auSetVol+"\n");
		
		//���١�����������ת��Ϊint�����ݿ���Ϊint
		int speed = Integer.parseInt(auSetSpd);
		int tone = Integer.parseInt(auSetPit);
		int volume = Integer.parseInt(auSetVol);
		
		//System.out.println(file.getOriginalFilename()+"\n");
		//System.out.println("userAge: "+userage+"\n");
		//model.addAttribute("Filename", "lenna");
		//return "down";
		
		//�ѱ��ύ�Ĳ����������ݿ�
		//ModelAndView mav = new ModelAndView();
		/*
		 * Date date=new Date(); perSet per = new
		 * perSet(username,userEmail,"1",date,userage,regSex,"��ͨȨ��",4);
		 * service.InsertByPerSet(per); //mav.addObject("info", "��Ϣ");
		 * //mav.setViewName("/WEB-INF/menu.jsp"); return "/WEB-INF/menu.jsp";
		 */
		/*
		 * ModelAndView mav = new ModelAndView(); Date date=new Date(); perSet per=new
		 * perSet("username",userEmail,date,userage,regSex);
		 * service.updateByPerSet(per); mav.setViewName("/WEB-INF/menu.jsp"); return
		 * mav;
		 */
		
		
		ModelAndView mav = new ModelAndView();
		//Date date=new Date();
		audioSet audio =new audioSet("Billy Kim",auSetVoiPer,speed,tone,volume);
		service.updateByAudioSet(audio);
		mav.setViewName("/WEB-INF/menu.jsp");
		return mav;
		
	}
		
	}