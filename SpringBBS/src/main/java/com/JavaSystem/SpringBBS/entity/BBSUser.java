package com.JavaSystem.SpringBBS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BBSUser {
	private int id;
	private String name;
	private String password;
}
