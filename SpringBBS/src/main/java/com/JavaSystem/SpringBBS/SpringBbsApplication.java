package com.JavaSystem.SpringBBS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JavaSystem.SpringBBS.entity.BBSMessage;
import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.entity.BBSUser;
import com.JavaSystem.SpringBBS.repository.BBSMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBbsApplication.class, args)
		.getBean(SpringBbsApplication.class).exe();
	}

	private final BBSMapper mapper;
	
	public void exe() {
		
		for(BBSUser row : mapper.AllUser()) {
			System.out.println(row);
		}
		
		for(BBSMessage row : mapper.AllMessage()) {
			System.out.println(row);
		}
		
		for(BBSThread row : mapper.AllThread()) {
			System.out.println(row);
		}		
		

	}
}
