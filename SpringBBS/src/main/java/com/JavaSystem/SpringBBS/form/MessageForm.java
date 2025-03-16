package com.JavaSystem.SpringBBS.form;

import lombok.Data;

@Data
public class MessageForm {
	private int user_id;
	private int thread_id;
	private String message;
}
