package com.JavaSystem.SpringBBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.JavaSystem.SpringBBS.form.UserForm;
import com.JavaSystem.SpringBBS.service.UserAuthService;

@Controller
public class AuthContoroller {

	@Autowired
	private UserAuthService userAuthService;
	
	@GetMapping("/login")
	public String Login() {
		return "BBS/login";
	}
	
	@PostMapping("/login")
	public String LoginAuth(UserForm f){
		if(userAuthService.UserNamePassCheck(f)){
			return "redirect:/ThreadList";
		}
		return "redirect:/login";		
	}
	
	@GetMapping("/logout")
	public String Logout() {
		userAuthService.UserNamePassDelete();
		return "BBS/login";
	}

	@GetMapping("/regist")
	public String DisplayRegistForm() {
		return "BBS/RegistForm";
	}
	
	@PostMapping("/regist")
	public String RegistUserData(UserForm f) {
		userAuthService.UserDataRegist(f);
		return "redirect:/login";
	}
}
