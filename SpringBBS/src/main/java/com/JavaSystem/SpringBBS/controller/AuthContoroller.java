package com.JavaSystem.SpringBBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JavaSystem.SpringBBS.form.UserForm;
import com.JavaSystem.SpringBBS.service.UserAuthService;

@Controller
public class AuthContoroller {

	@Autowired
	private UserAuthService userAuthService;
	
	/** form-backing beanの初期化 */
	
	@ModelAttribute
	public UserForm setUpForm(Model model) {
		model.addAttribute("userForm", new UserForm());
		return new UserForm();
	}
	
	
	@GetMapping("/login")
	public String Login() {
		return "BBS/login";
	}
	
	@PostMapping("/login")
	public String LoginAuth(UserForm form,@Validated UserForm f
			,BindingResult bindingResult,RedirectAttributes atrributes){
		System.out.println(bindingResult.getFieldErrors());
		if(bindingResult.hasErrors()) {	
			return "BBS/login";
		}
		
		if(userAuthService.UserNamePassCheck(form)){
			return "redirect:/ThreadList";
		}
		
		atrributes.addFlashAttribute("errMessage","ユーザ名かパスワードが間違っています");
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String Logout() {
		userAuthService.UserNamePassDelete();
		return "redirect:/login";
	}

	@GetMapping("/regist")
	public String DisplayRegistForm() {
		return "BBS/RegistForm";
	}
	
	@PostMapping("/regist")
	public String RegistUserData(UserForm form,@Validated UserForm f,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {			
			return "BBS/RegistForm";
		}
		userAuthService.UserDataRegist(form);
		return "redirect:/login";
	}
}
