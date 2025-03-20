package com.JavaSystem.SpringBBS.service;

import java.util.List;

import com.JavaSystem.SpringBBS.entity.BBSMessage;
import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.form.MessageForm;
import com.JavaSystem.SpringBBS.form.ThreadEditForm;
import com.JavaSystem.SpringBBS.form.ThreadForm;

public interface BBSMapperService {
	boolean ThreadCreate(ThreadForm f);
	List<BBSThread> ShowIndex();
	List<BBSMessage> GetMessages(int id);
	void PostMessage(MessageForm form);
	BBSThread ThreadSelectById(int id);
	void ThreadUpdate(ThreadEditForm form);
	void DeleteThread(int id);
}
