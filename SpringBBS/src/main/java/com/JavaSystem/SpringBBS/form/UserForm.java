package com.JavaSystem.SpringBBS.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserForm {
	@NotBlank(message="ユーザ名が未入力です")
	private String username;
	@NotBlank(message="パスワードが未入力です")
	private String password;
}
