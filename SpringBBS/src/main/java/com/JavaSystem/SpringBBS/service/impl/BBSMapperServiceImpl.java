package com.JavaSystem.SpringBBS.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaSystem.SpringBBS.entity.BBSMessage;
import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.form.MessageForm;
import com.JavaSystem.SpringBBS.form.ThreadEditForm;
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
		String title = form.getTitle();
		mapper.CreateThread(title,userSession.getId());
		return true;
	}
	
	public List<BBSThread> ShowIndex() {
		System.out.println(mapper.AllThread());
		return mapper.AllThread(); 
	}

	public List<BBSMessage> GetMessages(int id) {
		return mapper.GetMessages(id);
	}
	
	public void PostMessage(MessageForm form) {
		mapper.PostMessage(form);
	}
	
	public BBSThread ThreadSelectById(int id) {		
		 return mapper.ThreadSelectById(id);
	}
	
	public void ThreadUpdate(ThreadEditForm form) {
		mapper.ThreadUpdate(form);
	}
	
	public void DeleteThread(int id) {
		mapper.DeleteThread(id);
	}
	
	//スレッドタイトルが重複しているか 重複あり：true 重複なし：false
	public boolean HasOverlappingThreadTitle(String title) {
		
		BBSThread SqlResult = mapper.HasOverlappingThreadTitle(title); 		
		if(Objects.isNull(SqlResult))return false;
		
		return true;
	}
	
	//スレッドタイトルは更新するタイトルと重複しているか 重複あり：true 重複なし：false
	public boolean ThreadTitleEqualUpdateTitle(int id,String title) {
		
		BBSThread SqlResult = mapper.ThreadSelectById(id);
		if(SqlResult.getTitle().equals(title))return true;
				
		return false;
	}
}
