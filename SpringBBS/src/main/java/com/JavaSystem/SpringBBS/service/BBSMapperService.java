package com.JavaSystem.SpringBBS.service;

import java.util.List;

import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.form.ThreadForm;

public interface BBSMapperService {
	boolean ThreadCreate(ThreadForm f);
	List<BBSThread> ShowIndex();
}
