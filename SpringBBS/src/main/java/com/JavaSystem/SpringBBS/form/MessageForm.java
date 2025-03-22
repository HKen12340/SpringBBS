package com.JavaSystem.SpringBBS.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageForm {
	private int user_id;
	private int thread_id;
	@NotBlank(message="メッセージが未入力です")
	private String message;
}
