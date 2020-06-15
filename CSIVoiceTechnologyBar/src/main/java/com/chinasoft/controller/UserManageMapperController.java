package com.chinasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.pojo.User;
import com.chinasoft.service.impl.UserManageMapperServiceImpl;

@Controller
@RequestMapping("/usermanage")
public class UserManageMapperController {

	@Autowired
	
	private UserManageMapperServiceImpl service = new UserManageMapperServiceImpl();
	
	@RequestMapping("/user")
	public String test() {

		return "/WEB-INF/userManage.jsp";
	}
	
	//��ѯ�����û��������������û�����ʾҳ��
	@RequestMapping("/selectAllUser")
	public String selectAllUser(Model model) {
		System.out.println("Entering toMyComment...");
		
		List<User> list = service.queryAllUser();
		model.addAttribute("list", list);
		/*
		 * ModelAndView mav = new ModelAndView(); mav.addObject("list", list);
		 * mav.setViewName("/WEB-INF/userManage.jsp");
		 */
		return "/WEB-INF/userManage.jsp";
	}
	//��ת������û�
	@RequestMapping("/toAddUser")
	public String toAddUser() {

		return "/WEB-INF/addUser.jsp";
	}
	//����û�
	@RequestMapping("/addUser")
	public String addUser(User user) {
		System.out.println("addUser"+user);
		service.InsertUserByUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/usermanage/selectAllUser");
		return "/usermanage/selectAllUser";
	}
	//��ת�������û�
	@RequestMapping("/toUpdateUser")
	public String toUpdateUserManage(int userid,Model model) {
		
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/updateUserManage.jsp");
		return mav;*/
		User user = service.selectUserById(userid);
		model.addAttribute("Quser", user);
		return "/WEB-INF/updateUserManage.jsp";
	}
	//�����û�
	@RequestMapping("/updateUser")
	public String updateUserManage(User user) {
		System.out.println("updateUser=>"+user);
		service.updateUserByUser(user);
		return "/usermanage/selectAllUser";
	}
	//ɾ���û�
	@RequestMapping("/deleteUser/{userid}")
	public String deleteUser(@PathVariable("userid") int userid) {
		User user = service.selectUserById(userid);
		System.out.println("deleteUser=>"+user);
		service.deleteUserById(userid);
		return "redirect:/usermanage/selectAllUser";
	}
}
