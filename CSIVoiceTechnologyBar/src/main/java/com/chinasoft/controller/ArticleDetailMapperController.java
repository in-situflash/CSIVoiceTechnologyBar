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

	/* 进入文章详细页面时调用 传入参数：文章id：a_id */
	@RequestMapping("/getAll") 
	public ModelAndView getAll(HttpSession session, int a_id) {
		ModelAndView mav = new ModelAndView();
		/* 获取登录用户名obj */
		Object usernameobj = session.getAttribute("username");
		/* 如果未登录（非法访问） */
		if(usernameobj == null) {
			mav.setViewName("/WEB-INF/login.jsp");
			return mav;
		}else {
			String username = usernameobj.toString();
			/* 查询用户的语音设置 */
			audioSet audioSet = service.selectAudioSetByUsername(username);
			/* 查询文章详细内容 */
			ArticleDetail articleDetail = service.getAllById(a_id);
			/* 获取发表文章用户的用户名 */
			String Ausername = articleDetail.getUsername();
			/* 获取发表文章用户的头像 */
			String AImageUrl = service.selectImageByUsername(Ausername);
			/* 通过文章id查询这篇文章对应的评论 */
			List<Comment> comments = service.getCommentsByArticleId(a_id);
			/* 发表评论的用户的头像url列表 */
			List<String> CImageUrls = new ArrayList<String>();
			/* 发表评论用户的用户名 */
			String CUsername;
			/* 发表评论用户的头像url*/
			String CImageUrl;
			for (int i = 0; i < comments.size(); i++) {
				/* 查询评论的用户名 */
				CUsername = comments.get(i).getUsername();
				/* 查询评论的头像url */
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
		 
	}
	
	/* 删除评论id对应的评论 传入参数：1.评论id c_id 2.文章id a_id(用于返回对应的文章) */
	@RequestMapping("/deleteCommentByC_id")
	public ModelAndView deleteCommentByC_id(int c_id,int a_id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		/* 获取登录用户名obj */
		Object usernameobj = session.getAttribute("username");
		/* 如果未登录（非法访问） */
		if(usernameobj == null) {
			mav.setViewName("/WEB-INF/login.jsp");
			return mav;
		}else{             //如果想要删除别的用户的评论（非法访问）
			String username = usernameobj.toString();
			String usernameOfDeleteComment = service.selectUsernameByC_id(c_id);
			/* 如果是管理员或者删除的是自己的评论 */
			if(username.length()<6 || username.equals(usernameOfDeleteComment)) {
				/* 删除评论id对应的评论 */
				service.deleteCommentByC_id(c_id);
				/* 回到原来的页面 */
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
			}else {									//到非法访问页面
				mav.setViewName("/WEB-INF/illegal.jsp");
				return mav;
		
			}
		}
				
	}
	
	/* Ajax 对评论点赞 传入参数：评论实体（只要包含评论id c_id 就够了） */
	@RequestMapping("/updateC_likesByC_id")
	@ResponseBody
	public Map<String,String> updateC_likesByC_id(@RequestBody Comment comment) { 
		
		Map<String,String> map = new HashMap<String, String>();
		/* 获取评论id */
		int c_id = comment.getC_id();
		/* 更新评论的点赞数 */
		service.updateLikesByC_id(c_id); 
		/* 查询新的评论的点赞数 */
		int c_likes = service.selectC_likesByC_id(c_id);	
		map.put("c_likes", Integer.toString(c_likes)); 
		return map;
	
		
	}
	/* Ajax 对文章点赞 传入参数：ArticleDetail实体（只要包含文章id a_id 就够了） */
	@RequestMapping("/updateA_likesByA_id")
	@ResponseBody
	public Map<String,String> updateA_likesByA_id(@RequestBody ArticleDetail articleDetail) {
		Map<String,String> map = new HashMap<String, String>();
		/* 获取文章id */
		int a_id = articleDetail.getA_id();
		/* 更新文章的点赞数 */
		service.updateLikesByA_id(a_id); 
		/* 查询新的文章的点赞数 */
		int a_likes = service.selectA_likesByA_id(a_id);
		map.put("a_likes", Integer.toString(a_likes));
		return map;
	}
	
	/* 查询用户发表的所有评论id 传入参数：comment实体（只要包含username就可以了） */
	@RequestMapping("/selectC_idsByUsername")
	@ResponseBody
	public Map<String,List<Integer>> selectC_idsByUsername(@RequestBody Comment comment) {
		/* 获取username */
		String username  = comment.getUsername();
		/* 查询用户的所有评论id */
		List<Integer> c_ids = service.selectC_idsByUsername(username); 	
		Map<String,List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("c_ids", c_ids);
		return map;
	}

	/* 下载文件 传入参数：文件名 filename */
	@RequestMapping(value="downloadImage",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadImage(HttpServletRequest request, @RequestParam("filename")String filename)throws IOException{
		/* 文件存放路径 */
		String downloadFilePath="D:\\java";
		File file = new File(downloadFilePath + File.separator+filename);
		HttpHeaders headers = new HttpHeaders();
		String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	
}
