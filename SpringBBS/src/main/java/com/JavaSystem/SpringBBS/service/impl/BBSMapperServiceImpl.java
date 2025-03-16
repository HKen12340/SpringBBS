package com.JavaSystem.SpringBBS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaSystem.SpringBBS.entity.BBSMessage;
import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.form.MessageForm;
import com.JavaSystem.SpringBBS.form.ThreadForm;
import com.JavaSystem.SpringBBS.repository.BBSMapper;
import com.JavaSystem.SpringBBS.service.BBSMapperService;
import com.JavaSystem.SpringBBS.session.UserSession;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BBSMapperServiceImpl implements BBSMapperService {
	
	@Autowired
	private UserSession userSession;
	
	private final BBSMapper mapper;
	
	
	//スレッド名が重複した場合にfalseを返す ※追加予定
	public boolean ThreadCreate(ThreadForm form) {
		System.out.println("form.getTitle()：" + form.getTitle());
		System.out.println("userSession.getId()：" + userSession.getId());
		String title = form.getTitle();
		mapper.CreateThread(title,userSession.getId());
		return true;
	}
	
	public List<BBSThread> ShowIndex() {
		return mapper.AllThread(); 
	}

	public List<BBSMessage> GetMessages(int id) {
		return mapper.GetMessages(id);
	}
	
	public void PostMessage(MessageForm form) {
		mapper.PostMessage(form);
	}
	
	
	
}
