package com.common.service;

import com.common.entity.AdminSignin;
import com.common.exception.SigninException;

public interface AdminService {
	public AdminSignin createAdmin(AdminSignin user) throws SigninException;
}