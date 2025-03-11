package com.JavaSystem.SpringBBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JavaSystem.SpringBBS.form.ThreadForm;
import com.JavaSystem.SpringBBS.service.BBSMapperService;
import com.JavaSystem.SpringBBS.service.UserAuthService;

@Controller
@RequestMapping("")
public class BBSController {
	
	@Autowired
	private UserAuthService userAuthService;
	
	@Autowired
	private BBSMapperService bbsMapperService;

	@GetMapping("/ThreadList")
	public String ThreadList(Model model) {		
		if(userAuthService.LoginSessionCheck()) {
			System.out.println(bbsMapperService.ShowIndex());
			model.addAttribute("threads",bbsMapperService.ShowIndex());
			return "BBS/ThreadList";
		}
		return "redirect:/login";	
	}
	
	@GetMapping("/NewThread")
	public String DisplayNewThreadForm(){
		if(userAuthService.LoginSessionCheck()) {
			return "BBS/NewThreadForm";			
		}
		return "redirect:/login";			
	}
	
	@PostMapping("/NewThread")
	public String CreateThread(ThreadForm form) {		
		bbsMapperService.ThreadCreate(form);
		return "BBS/ThreadList";
	}
	
}
