package com.chinasoft.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.User;
import com.chinasoft.service.impl.UserManageMapperServiceImpl;

@Controller
//@RequestMapping("/usermanage")
public class UserManageMapperController {

	@Autowired
	
	private UserManageMapperServiceImpl service = new UserManageMapperServiceImpl();
	
	@RequestMapping("/usermanage/user")
	public String test() {

		return "/WEB-INF/userManage.jsp";
	}
	
	//��ѯ�����û��������������û�����ʾҳ��
	@RequestMapping("/usermanage/selectAllUser")
	public String selectAllUser(HttpSession session,Model model, String username) {
		System.out.println("Entering userManage");
		username = (String)session.getAttribute("username");	
			List<User> list = service.queryAllUser();
			int column=list.size();
			model.addAttribute("list", list);
			model.addAttribute("column", column);
			model.addAttribute("username", username);
		return "/WEB-INF/userManage.jsp";
	}
	//��ת������û�
	@RequestMapping("/usermanage/toAddUser")
	public String toAddUser() {

		return "/WEB-INF/addUser.jsp";
	}
	//����û�
	@RequestMapping("/usermanage/addUser")
	public String addUser(User user) {
		System.out.println("addUser"+user);
		service.InsertUserByUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/usermanage/selectAllUser");
		return "/usermanage/selectAllUser";
	}
	//��ת�������û�
	@RequestMapping("/usermanage/toUpdateUser")
	public String toUpdateUserManage(int userid,Model model) {

		User user = service.selectUserById(userid);
		model.addAttribute("Quser", user);
		return "/WEB-INF/updateUserManage.jsp";
	}
	//�����û�
	@RequestMapping("/usermanage/updateUser")
	public String updateUserManage(User user) {
		System.out.println("updateUser=>"+user);
		service.updateUserByUser(user);
		return "/usermanage/selectAllUser";
	}
	//ɾ���û�
	@RequestMapping("/usermanage/deleteUser/{userid}")
	public String deleteUser(@PathVariable("userid") int userid) {
		User user = service.selectUserById(userid);
		System.out.println("deleteUser=>"+user);
		service.deleteUserById(userid);
		return "/usermanage/selectAllUser";
	}
}
