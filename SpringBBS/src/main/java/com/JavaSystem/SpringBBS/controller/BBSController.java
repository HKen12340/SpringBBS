package com.JavaSystem.SpringBBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JavaSystem.SpringBBS.form.MessageForm;
import com.JavaSystem.SpringBBS.form.ThreadForm;
import com.JavaSystem.SpringBBS.service.BBSMapperService;
import com.JavaSystem.SpringBBS.service.UserAuthService;
import com.JavaSystem.SpringBBS.session.UserSession;

@Controller

public class BBSController {

	@Autowired
	private UserAuthService userAuthService;
	
	@Autowired
	private BBSMapperService bbsMapperService;
	
	@Autowired
	private UserSession userSession;

	@GetMapping("/ThreadList")
	public String ThreadList(Model model) {
		if(!userAuthService.LoginSessionCheck()) {
			return "redirect:/login";	
		}
		model.addAttribute("threads",bbsMapperService.ShowIndex());
		return "BBS/ThreadList";
	}
	
	@GetMapping("/Thread/{id}")	
	public String ShowThread(@PathVariable(name = "id")  Integer id,Model model){
		
		if(!userAuthService.LoginSessionCheck()) {
			return "redirect:/login";	
		}
		model.addAttribute("thread",bbsMapperService.ThreadSelectById(id));
		model.addAttribute("msgs",bbsMapperService.GetMessages(id));
		model.addAttribute("thread_id",id);
		model.addAttribute("user_id",userSession.getId());
		return "BBS/Thread";
	}

	@GetMapping("/NewThread")
	public String DisplayNewThreadForm(){
		if(!userAuthService.LoginSessionCheck()) {
			return "redirect:/login";	
		}
		
		return "BBS/NewThreadForm";		
	}
	
	@PostMapping("/NewThread")
	public String CreateThread(ThreadForm form) {
		if(!userAuthService.LoginSessionCheck()) {
			return "redirect:/login";	
		}
		bbsMapperService.ThreadCreate(form);
		return "redirect:/ThreadList";
	}
	
	@PostMapping("/SendMeg")
	public String SendMsg(MessageForm form) {
		bbsMapperService.PostMessage(form);
		return "redirect:/Thread/"+form.getThread_id();
		
	}
		
}
