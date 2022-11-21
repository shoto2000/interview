package com.common.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminLogin {
	@NotNull(message = "Mobile No is required")
	private String mobileNo;
	
	
	@NotNull(message = "Password is required")
	private String password;
}
