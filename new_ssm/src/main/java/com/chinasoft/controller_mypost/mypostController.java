package com.chinasoft.controller_mypost;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.Article;
import com.chinasoft.service.impl.ArticleMapper_mypostServiceImpl;

@Controller
@RequestMapping("/mypostController")
public class mypostController {

	@Autowired
	ArticleMapper_mypostServiceImpl service;
	
	@RequestMapping("/tomenu")
	public ModelAndView tomenu() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ADMIN", "ÕÅÈý");
		mav.setViewName("/WEB-INF/menu.jsp");
		return mav;
	}

	@RequestMapping("/tomypost")
	public ModelAndView tomypost(int page, String username) {
		int SELECT_TYPE=0;
		Map<String, Object> map = new HashMap<>();
		int start = 10*page - 10;
		int end = 10;
		map.put("username", username);
		map.put("start",start);
		map.put("end", end);
		List<Article> article = service.FindmyAllByLimit(map);
		List<Article> temparticle = service.FindmyAll(username);
		map.clear();
		int lastid = service.selectLastmyArticle();
		//String article = service.FindOne();
		int maxpage = 0;
		double temp1 = (double)(temparticle.size())/10;
		int temp2 = temparticle.size()/10;
		if((temp1-temp2)==0) {
			maxpage = temp2;
		}
		else if((temp1-temp2)>0) {
			maxpage = temp2 + 1;
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", username);
		mav.addObject("page", page);
		mav.addObject("maxpage", maxpage);
		mav.addObject("allarticle", article);
		mav.addObject("alldata", temparticle.size());
		mav.addObject("SELECT_TYPE", SELECT_TYPE);
		mav.addObject("lastid", lastid);
		mav.setViewName("/WEB-INF/myPost.jsp");
		return mav;
	}
	
	@RequestMapping("/selectmypost")
	public ModelAndView selectmypost(String title, int selectpage,String username) {
		int SELECT_TYPE=1;
		Map<String, Object> maptitle = new HashMap<>();
		maptitle.put("username", username);
		maptitle.put("title", title);
		List<Article> temparticle = service.FindmyByPar(maptitle);
		int start = 10*selectpage - 10;
		int end = 10;
		maptitle.put("start",start);
		maptitle.put("end", end);
		List<Article> selectarticle = service.FindmyByParByLimit(maptitle);
		int maxpage = 0;
		double temp1 = (double)(temparticle.size())/10;
		int temp2 = temparticle.size()/10;
		if((temp1-temp2)==0) {
			maxpage = temp2;
		}
		else if((temp1-temp2)>0) {
			maxpage = temp2 + 1;
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", username);
		mav.addObject("allarticle", selectarticle);
		mav.addObject("page", selectpage);
		mav.addObject("maxpage", maxpage);
		mav.addObject("alldata", temparticle.size());
		mav.addObject("SELECT_TYPE", SELECT_TYPE);
		mav.addObject("title", title);
		mav.addObject("lastid", service.selectLastmyArticle());
		mav.setViewName("/WEB-INF/myPost.jsp");
		return mav;
	}
	
	@RequestMapping("/addmypost")
	public ModelAndView addmypost(int lastid, String title,String essay,String username) {
		Article addarticle = new Article();
		addarticle.setUsername(username);
		addarticle.setEssay(essay);
		addarticle.setTitle(title);
		addarticle.setA_id(lastid+1);
		LocalDateTime d = LocalDateTime.now();
		addarticle.setA_createtime(d); 
		service.addmyArticle(addarticle);
		ModelAndView mav = new ModelAndView();
		String url = "/mypostController/tomypost?page=1";
		mav.setViewName(url);
		return mav;
	}

	
	@RequestMapping("/deletemypost")
	public ModelAndView deletemypost(int a_id[],String username) {
		for(int i=0; i<a_id.length; i++) {
			service.deletemyArticle(a_id[i]);
		}
		ModelAndView mav = new ModelAndView();
		String url = "/mypostController/tomypost?page=1";
		mav.setViewName(url);
		return mav;
	}
	
}
