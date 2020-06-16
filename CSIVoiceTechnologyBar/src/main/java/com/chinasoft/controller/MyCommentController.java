package com.chinasoft.controller;

import java.util.List;

import com.chinasoft.pojo.TitledComment;
import com.chinasoft.pojo.audioSet;
import com.chinasoft.service.impl.audioSetMapperServiceImpl;
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

	@Autowired
	audioSetMapperServiceImpl audioServ;

	@RequestMapping("/mycomment/test")
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
	
	
	@RequestMapping("/mycomment/route")
	// 测试是否能再mapping之间使用Model传递参数
	public String commentRouter(Model model) {
		System.out.println("Entering commentRouter...");

//		model.addAttribute("username", "Asichurter");
		model.addAttribute("type", "test");
		model.addAttribute("msg", "test whether we can pass params across controllers");
		
		return "msg";
	}
	
	@RequestMapping("/mycomment/show")
	// 我的评论页面
	public String toMyComment(HttpSession session, Model model) {
		System.out.println("Entering toMyComment...");

		// 从session中获取登录的用户名
		String username = (String)session.getAttribute("username");
//		System.out.println("username: "+username);

		boolean isLogin = !(username == null || username == "");
		model.addAttribute("islogin", isLogin);
		System.out.println("username: "+username);

		audioSet audioset = audioServ.selectAudiosetByUser(username);

		// 只有在获得到有效用户名时才会进行数据检索
		if (isLogin) {

			// TODO: 嵌入动态用户名(Done)
			List<TitledComment> comments = service.selectTitledCommentByUser(username);

			model.addAttribute("mycomments", comments);
			model.addAttribute("totalComment", comments.size());
			model.addAttribute("audioset", audioset);
		}

		return "/WEB-INF/myComment.jsp";
	}


	@RequestMapping("/mycomment/delete")
	// 非访问方法，仅用于前台向后台传递操作和参数
	// 使用路径参数，整体为一个id字符串，id之间使用"-"隔开
	public String deleteComments(Model model, HttpSession session, String ids){
		System.out.println("Entering deleteComments...");

		String curUsername = (String)session.getAttribute("username");
		boolean authorized = service.checkOperationAuthorization(ids, curUsername);
		int deleted;

		// 先判断当前请求删除操作的用户是否是评论者本人
		if (!authorized){
			model.addAttribute("title", "Ilegal Operation");
			model.addAttribute("type", "Error");
			model.addAttribute("msg", "Unmatched operator of deleted comments");
			model.addAttribute("desc", "Ilegally try to delete comments through url without authorization");
			return "/WEB-INF/msg.jsp";
		}
		else{
			deleted = service.deleteComments(ids);
		}

		// 删除失败
		// TODO: 删除失败后的提示
		if (deleted == 0){
			System.err.println("Fail to delete comments "+ids);
		}

		// 删除完成后返回到“我的评论”页面
		return "/mycomment/show";
	}

	@RequestMapping("/mycomment/edit")
	// 非访问方法，仅用于前台向后台传递操作和参数
	// 使用路径参数传递
	public String editComment(HttpSession session, Model model,
							  int cid, String cont){
		System.out.println("Entering editComment...");

		String curUsername = (String)session.getAttribute("username");
		boolean authorized = service.checkOperationAuthorization(cid+"", curUsername);
		int edited;

		// 先判断当前请求编辑操作的用户是否是评论者本人
		if (!authorized){
			model.addAttribute("title", "Ilegal Operation");
			model.addAttribute("type", "Error");
			model.addAttribute("msg", "Unmatched operator of edited comments");
			model.addAttribute("desc", "Ilegally try to edit comment through url without authorization");
			return "/WEB-INF/msg.jsp";
		}
		else{
			edited = service.editComment(cid, cont);
		}

		// 编辑失败
		// TODO: 编辑失败的后续操作
		if (edited == 0){
			System.err.println("Fail to edit comment, id="+cid+", content="+cont);
		}

		// 编辑完成后返回到“我的评论”页面
		return "/mycomment/show";
	}
}
