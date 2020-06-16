package com.chinasoft.controller_post;

import java.nio.channels.SeekableByteChannel;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.Article;
import com.chinasoft.service.impl.ArticleMapper_postServiceImpl;
import com.mysql.cj.Session;

@Controller
@RequestMapping("/postController")
public class postController {

	@Autowired
	ArticleMapper_postServiceImpl service;

	@RequestMapping("/tomenu")
	public ModelAndView tomenu() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ADMIN", "张三");
		mav.setViewName("/WEB-INF/menu.jsp");
		return mav;
	}

	@RequestMapping("/topost")
	public ModelAndView topost(HttpSession session, int page) {
		int SELECT_TYPE = 0;
		String username = (String) session.getAttribute("username");
		String privilege = service.findPrivilege(username);
		if (username != null && username != "") {
			Map<String, Object> map = new HashMap<>();
			int start = 10 * page - 10;
			int end = 10;
			map.put("start", start);
			map.put("end", end);
			List<Article> article = service.FindAllByLimit(map);
			List<Article> temparticle = service.FindAll();
			map.clear();
			int lastid;
			try {
				lastid = service.selectLastArticle();
			} catch (Exception e) {
				lastid = 0;
			}
			// String article = service.FindOne();
			int maxpage = 0;
			double temp1 = (double) (temparticle.size()) / 10;
			int temp2 = temparticle.size() / 10;
			if ((temp1 - temp2) == 0) {
				maxpage = temp2;
			} else if ((temp1 - temp2) > 0) {
				maxpage = temp2 + 1;
			}

			ModelAndView mav = new ModelAndView();
			mav.addObject("privilege", privilege);
			mav.addObject("username", username);
			mav.addObject("page", page);
			mav.addObject("maxpage", maxpage);
			mav.addObject("allarticle", article);
			mav.addObject("alldata", temparticle.size());
			mav.addObject("SELECT_TYPE", SELECT_TYPE);
			mav.addObject("lastid", lastid);
			mav.setViewName("/WEB-INF/post.jsp");
			return mav;
		}

		else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("../index.jsp");
			return mav;
		}
	}

	@RequestMapping("/selectpost")
	public ModelAndView selectpost(HttpSession session, String title, int selectpage) {
		int SELECT_TYPE = 1;
		String username = (String) session.getAttribute("username");
		String privilege = service.findPrivilege(username);
		if (username != null && username != "") {
			Map<String, Object> maptitle = new HashMap<>();
			maptitle.put("title", title);
			List<Article> temparticle = service.FindByPar(maptitle);
			int start = 10 * selectpage - 10;
			int end = 10;
			maptitle.put("start", start);
			maptitle.put("end", end);
			List<Article> selectarticle = service.FindByParByLimit(maptitle);
			int maxpage = 0;
			double temp1 = (double) (temparticle.size()) / 10;
			int temp2 = temparticle.size() / 10;
			if ((temp1 - temp2) == 0) {
				maxpage = temp2;
			} else if ((temp1 - temp2) > 0) {
				maxpage = temp2 + 1;
			}
			int lastid;
			try {
				lastid = service.selectLastArticle();
			} catch (Exception e) {
				lastid = 0;
			}
			ModelAndView mav = new ModelAndView();
			mav.addObject("privilege", privilege);
			mav.addObject("allarticle", selectarticle);
			mav.addObject("page", selectpage);
			mav.addObject("maxpage", maxpage);
			mav.addObject("alldata", temparticle.size());
			mav.addObject("SELECT_TYPE", SELECT_TYPE);
			mav.addObject("title", title);
			mav.addObject("lastid", lastid);
			mav.setViewName("/WEB-INF/post.jsp");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("../index.jsp");
			return mav;
		}
	}

	@RequestMapping("/addpost")
	public ModelAndView addpost(HttpSession session, int lastid, String title, String essay) {
		Article addarticle = new Article();
		String username = (String) session.getAttribute("username");
		if (username != null && username != "") {
			addarticle.setUsername(username);
			addarticle.setEssay(essay);
			addarticle.setTitle(title);
			addarticle.setA_id(lastid + 1);
			LocalDateTime d = LocalDateTime.now();
			addarticle.setA_createtime(d);
			service.addArticle(addarticle);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/postController/topost?page=1");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("../index.jsp");
			return mav;
		}
	}

	@RequestMapping("/deletepost")
	public ModelAndView deletepost(HttpSession session, int a_id[]) {
		String username = (String) session.getAttribute("username");
		if (username != null && username != "" && service.findPrivilege(username).equals("管理员") == true) {
			for (int i = 0; i < a_id.length; i++) {
				service.deleteArticle(a_id[i]);
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/postController/topost?page=1");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("../index.jsp");
			return mav;
		}
	}

}
