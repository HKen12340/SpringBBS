package com.JavaSystem.SpringBBS.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ThreadForm {
	@NotBlank(message="タイトルが未入力です")
	private String title;
}
