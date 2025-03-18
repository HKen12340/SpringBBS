package com.JavaSystem.SpringBBS.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BBSMessage {
	private int id;
	private String msg_text;
	private int replay_id;
	private LocalDateTime created_at;
	private int thread_id;
	private int user_id;
	private BBSUser bbsuser;
//	private List<BBSThread> thread_id;
//	private List<BBSUser> user_id;
}
