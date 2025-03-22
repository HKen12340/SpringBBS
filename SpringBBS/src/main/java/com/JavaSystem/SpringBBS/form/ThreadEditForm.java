package com.JavaSystem.SpringBBS.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ThreadEditForm {
	private int id;
	@NotBlank(message="タイトルが未入寮です")
	private String title;
}
