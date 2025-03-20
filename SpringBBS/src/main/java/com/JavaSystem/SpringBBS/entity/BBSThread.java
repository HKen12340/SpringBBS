package com.JavaSystem.SpringBBS.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BBSThread {
	private int id;
	private String title;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private int create_userid; 
}
