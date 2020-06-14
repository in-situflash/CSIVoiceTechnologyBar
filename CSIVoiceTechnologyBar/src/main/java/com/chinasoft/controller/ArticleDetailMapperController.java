package com.chinasoft.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.ArticleDetail;
import com.chinasoft.pojo.Comment;
import com.chinasoft.pojo.audioSet;
import com.chinasoft.service.impl.ArticleDetailMapperServiceImpl;


@Controller
@RequestMapping("/articleDetail")
public class ArticleDetailMapperController {

	@Autowired
	ArticleDetailMapperServiceImpl service;


	@RequestMapping("/getAll") 
	public ModelAndView getAll(HttpSession session, int a_id) {
		ModelAndView mav = new ModelAndView();
		String username = session.getAttribute("username").toString();
		audioSet audioSet = service.selectAudioSetByUsername(username);
		ArticleDetail articleDetail = service.getAllById(a_id);
		String Ausername = articleDetail.getUsername();
		String AImageUrl = service.selectImageByUsername(Ausername);
		List<Comment> comments = service.getCommentsByArticleId(a_id);
		List<String> CImageUrls = new ArrayList<String>();
		String CUsername;
		String CImageUrl;
		for (int i = 0; i < comments.size(); i++) {
			CUsername = comments.get(i).getUsername();
			CImageUrl = service.selectImageByUsername(CUsername);
			CImageUrls.add(CImageUrl);
		}
		mav.addObject("AImageUrl", AImageUrl);
		mav.addObject("CImageUrls", CImageUrls);
		mav.addObject("articleDetail", articleDetail);
		mav.addObject("comments", comments);
		mav.addObject("a_id", a_id);
		mav.addObject("audioSet", audioSet);
		mav.setViewName("/WEB-INF/comment.jsp");
		return mav; 
	}
	
	@RequestMapping("/deleteCommentByC_id")
	public ModelAndView deleteCommentByC_id(int c_id,int a_id) {
		ModelAndView mav = new ModelAndView();
		service.deleteCommentByC_id(c_id);
		ArticleDetail articleDetail = service.getAllById(a_id);
		String Ausername = articleDetail.getUsername();
		String AImageUrl = service.selectImageByUsername(Ausername);
		List<Comment> comments = service.getCommentsByArticleId(a_id);
		List<String> CImageUrls = new ArrayList<String>();
		String CUsername;
		String CImageUrl;
		for (int i = 0; i < comments.size(); i++) {
			CUsername = comments.get(i).getUsername();
			CImageUrl = service.selectImageByUsername(CUsername);
			CImageUrls.add(CImageUrl);
		}
		mav.addObject("AImageUrl", AImageUrl);
		mav.addObject("CImageUrls", CImageUrls);
		mav.addObject("articleDetail", articleDetail);
		mav.addObject("comments", comments);
		mav.addObject("a_id", a_id);
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

	@RequestMapping("/selectC_idsByUsername")
	@ResponseBody
	public Map<String,List<Integer>> selectC_idsByUsername(@RequestBody Comment comment) {
		String username  = comment.getUsername();
		List<Integer> c_ids = service.selectC_idsByUsername(username); 	
		//int a_likes = service.selectA_likesByA_id(a_id);
		Map<String,List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("c_ids", c_ids);
		return map;
	}
	
	@RequestMapping(value="downloadImage",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadImage(HttpServletRequest request, @RequestParam("filename")String filename)throws IOException{
		String downloadFilePath="D:\\java";
		File file = new File(downloadFilePath + File.separator+filename);
		HttpHeaders headers = new HttpHeaders();
		String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	
}
