package com.JavaSystem.SpringBBS.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.JavaSystem.SpringBBS.entity.BBSMessage;
import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.entity.BBSUser;

@Mapper
public interface BBSMapper {
	List<BBSThread> AllThread();
	List<BBSUser> AllUser();
	List<BBSMessage> AllMessage();	
}
