package com.JavaSystem.SpringBBS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BBSController {
	@GetMapping("/")
	public String ThreadList() {
		return "BBS/ThreadList";
	}
	
	
}
