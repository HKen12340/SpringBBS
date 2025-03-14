package com.JavaSystem.SpringBBS.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.JavaSystem.SpringBBS.entity.BBSMessage;
import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.entity.BBSUser;
import com.JavaSystem.SpringBBS.form.UserForm;

@Mapper
public interface BBSMapper {
	List<BBSThread> AllThread();
	
	List<BBSUser> AllUser();
	List<BBSMessage> AllMessage();
	
	void RegistUser(UserForm f);
	BBSUser SeachUser(UserForm f);
	void CreateThread(String title,Integer user_id);
	List<BBSMessage> GetMessages(int id); 
}
