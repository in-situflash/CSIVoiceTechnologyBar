package com.chinasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/testMenu")
	public String toMenu() {
		System.out.println("Entering toMenu test...");
		return "/WEB-INF/menu.jsp";
	}
	
	@RequestMapping("/testRouteToComment")
	public String routeToMyComment(Model model) {
		System.out.println("Entering routeToMyComment...");
		
		model.addAttribute("username", "Asichurter");
		
		return "/comment/mycomment";
	}
}
