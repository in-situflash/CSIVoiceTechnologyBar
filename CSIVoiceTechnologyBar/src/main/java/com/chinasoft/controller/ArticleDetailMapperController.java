package com.chinasoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.ArticleDetail;
import com.chinasoft.pojo.Comment;
import com.chinasoft.service.impl.ArticleDetailMapperServiceImpl;


@Controller
@RequestMapping("/articleDetail")
public class ArticleDetailMapperController {

	@Autowired
	ArticleDetailMapperServiceImpl service;

	@RequestMapping("/getAll")
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView();
		ArticleDetail articleDetail = service.getAllById(1);
		List<Comment> comments = service.getCommentsByArticleId(1);
		System.out.println(comments);
		System.out.println(articleDetail);
		mav.addObject("articleDetail", articleDetail);
		mav.addObject("comments", comments);
		mav.setViewName("/WEB-INF/comment.jsp");
		return mav;
	}
	
	@RequestMapping("/deleteCommentByC_id")
	public ModelAndView deleteCommentByC_id(int c_id) {
		ModelAndView mav = new ModelAndView();
		service.deleteCommentByC_id(c_id);
		System.out.println(c_id);
		ArticleDetail articleDetail = service.getAllById(1);
		List<Comment> comments = service.getCommentsByArticleId(1);
		mav.addObject("articleDetail", articleDetail);
		mav.addObject("comments", comments);
		mav.setViewName("/WEB-INF/comment.jsp");
		return mav;
	}
	
	@RequestMapping("/updateC_likesByC_id")
	@ResponseBody
	public Map<String,String> updateC_likesByC_id(@RequestBody Comment comment) { 
		int c_id = comment.getC_id();
		service.updateLikesByC_id(c_id); 
		int c_likes = service.selectC_likesByC_id(c_id);
		Map<String,String> map = new HashMap<String, String>();
		map.put("c_likes", Integer.toString(c_likes)); 
		return map;
	}
	
	@RequestMapping("/updateA_likesByA_id")
	@ResponseBody
	public Map<String,String> updateA_likesByA_id(@RequestBody ArticleDetail articleDetail) {
		int a_id = articleDetail.getA_id();
		service.updateLikesByA_id(a_id); 
		int a_likes = service.selectA_likesByA_id(a_id);
		Map<String,String> map = new HashMap<String, String>();
		map.put("a_likes", Integer.toString(a_likes));
		return map;
	}

}
