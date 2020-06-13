package com.chinasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.pojo.Comment;
import com.chinasoft.service.impl.CommentMapperServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/comment")
public class MyCommentController {
	
	@Autowired
	CommentMapperServiceImpl service;

	@RequestMapping("/comment/test")
	@ResponseBody
	// 测试用方法
	public Comment enterTest() {
		System.out.println("Entering enterTest...");

		List<Comment> comments = service.selectCommentByUser("zhangsan");
		Comment com = comments.get(0);

		System.out.println(com.getC_createtime());
//		return "/WEB-INF/myComment.jsp";
		return com;
	}
	
	
	@RequestMapping("/comment/route")
	// 测试是否能再mapping之间使用Model传递参数
	public String commentRouter(Model model) {
		System.out.println("Entering commentRouter...");
		
		model.addAttribute("username", "Asichurter");
		
		return "mycomment";
	}
	
	@RequestMapping("/comment/mycomment")
	// 我的评论页面
	public String toMyComment(HttpSession session, Model model) {
		System.out.println("Entering toMyComment...");

		// 从session中获取登录的用户名
		String username = (String)session.getAttribute("username");
//		System.out.println("username: "+username);

		// TODO: 嵌入动态用户名(Done)
		List<Comment> comments = service.selectCommentByUser(username);

		model.addAttribute("mycomments", comments);
		model.addAttribute("totalComment", comments.size());

		return "/WEB-INF/myComment.jsp";
	}


	@RequestMapping("/comment/delete")
	// 非访问方法，仅用于前台向后台传递操作和参数
	// 使用路径参数，整体为一个id字符串，id之间使用"-"隔开
	public String deleteComments(String ids){
		System.out.println("Entering deleteComments...");

		int deleted = service.deleteComments(ids);

		// 删除失败
		// TODO: 删除失败后的提示
		if (deleted == 0){
			System.err.println("Fail to delete comments "+ids);
		}

		// 删除完成后返回到“我的评论”页面
		return "/comment/mycomment";
	}

	@RequestMapping("/comment/edit")
	// 非访问方法，仅用于前台向后台传递操作和参数
	// 使用路径参数传递
	public String editComment(int cid, String cont){
		System.out.println("Entering editComment...");

		int edited = service.editComment(cid, cont);

		// 编辑失败
		// TODO: 编辑失败的后续操作
		if (edited == 0){
			System.err.println("Fail to edit comment, id="+cid+", content="+cont);
		}

		// 编辑完成后返回到“我的评论”页面
		return "/comment/mycomment";
	}
}
