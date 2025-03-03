package com.JavaSystem.SpringBBS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class BBSController {
	
	void SessionManage(String pass) {		
		if(pass.equals("TestValue")) {
			System.out.println("SessionData："+pass);
		}else {
			System.out.println("NoMatchPassword");
		}
	}
	
	@GetMapping("/ThreadList")
	public String ThreadList(HttpSession session) {
		
		session.setAttribute("test", "TstValue");
		
		SessionManage((String) session.getAttribute("test"));
		
		return "BBS/ThreadList";
	}
	
	
}
