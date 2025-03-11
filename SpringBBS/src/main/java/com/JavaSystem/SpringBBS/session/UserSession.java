package com.JavaSystem.SpringBBS.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
	private String username;
	private String password;
	private Integer id;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void deleteUsername() {
		this.username = null;
	}
	
	public void deletePassword() {
		this.password = null;
	}
	
	public void deleteId() {
		this.id =  null;
	}
}
