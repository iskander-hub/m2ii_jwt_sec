package org.m2ii.web;

import lombok.Data;

@Data
public class RegisterForm {
    
	private String username;
	private String password;
	private String repassword;
}
