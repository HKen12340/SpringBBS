package com.JavaSystem.SpringBBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JavaSystem.SpringBBS.form.LoginForm;
import com.JavaSystem.SpringBBS.service.UserAuthService;


@Controller
@RequestMapping("")
public class BBSController {
	
	@Autowired
	private UserAuthService userAuthService;
	
	@GetMapping("/login")
	public String Login() {
		return "BBS/login";
	}
	
	@PostMapping("/login")
	public String LoginAuth(Model model,LoginForm f){
		if(userAuthService.UserNamePassCheck(f.getUsername(),f.getPassword())) {
			return "BBS/ThreadList";
		}else {
			return " BBS/login";
		}
	}

	@GetMapping("/ThreadList")
	public String ThreadList() {		
		if(!userAuthService.LoginSessionCheck()) {
			return "redirect:/login";
		}else {
			return "BBS/ThreadList";
		}
		
	}
	
	@GetMapping("/logout")
	public String Logout() {
		userAuthService.UserNamePassDelete();
		return "BBS/login";
	}

}
