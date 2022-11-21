package com.common.service;

import com.common.entity.AdminLogin;
import com.common.exception.LoginException;
import com.common.exception.LogoutException;

public interface AdminLoginService {
	public String loginAdminAccount(AdminLogin adminLogin) throws LoginException;
	
	public String logoutAdminAccount(String uuid) throws LogoutException;
}
