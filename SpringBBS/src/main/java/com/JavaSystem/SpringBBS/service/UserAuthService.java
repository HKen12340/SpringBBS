package com.JavaSystem.SpringBBS.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaSystem.SpringBBS.session.UserSession;

@Service
public class UserAuthService {

	@Autowired
	private UserSession userSession;
	
	public boolean UserNamePassCheck(String name, String pass) {
		 
		final String TEST_USERNAME = "testname";
		final String TEST_PASSWORD = "password";
		
		if (TEST_USERNAME.equals(name) || TEST_PASSWORD.equals(pass)) {
			userSession.setUsername(name);
			userSession.setPassword(pass);
			return true;
		}
		return false;
	}
	
	public boolean LoginSessionCheck() {
		//BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		//if (name.equals("testname") && pass.equals("testpass")) {
		if (Objects.isNull(userSession.getUsername()) ||
				Objects.isNull(userSession.getPassword())) {
			//String encodeedPassword = bcpe.encode(pass);
			//System.out.println("SessionData：" + name + " " + encodeedPassword);
			return false;
		}
		return true;
	}
	
	public void UserNamePassDelete() {
		userSession.deleteUsername();
		userSession.deletePassword();
	}
}
