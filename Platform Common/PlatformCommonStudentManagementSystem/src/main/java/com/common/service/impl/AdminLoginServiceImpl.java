package com.common.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.entity.AdminLogin;
import com.common.entity.AdminSignin;
import com.common.entity.CurrentAdminSession;
import com.common.exception.LoginException;
import com.common.exception.LogoutException;
import com.common.repository.AdminRepo;
import com.common.repository.AdminSessionRepo;
import com.common.service.AdminLoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private AdminSessionRepo adminSessionRepo;

	@Override
	public String loginAdminAccount(AdminLogin adminLogin) throws LoginException {
		Optional<AdminSignin> opt = adminRepo.findByMobileNo(adminLogin.getMobileNo());

		if (!opt.isPresent()) {
			throw new LoginException("Enter valid mobile Number");
		}

		AdminSignin adminSignin = opt.get();
		Integer adminId = adminSignin.getId();
		Optional<CurrentAdminSession> currAdminSession = adminSessionRepo.findByAdminId(adminId);

		if (currAdminSession.isPresent()) {
			throw new LoginException("Admin Already logged in with this number");
		}

		if (adminSignin.getPassword().equals(adminLogin.getPassword())) {
			String uuid = RandomString.make(6);

			CurrentAdminSession currentAdminSession = new CurrentAdminSession(adminId, uuid, LocalDateTime.now());

			adminSessionRepo.save(currentAdminSession);

			return currentAdminSession.toString();
		} else {
			throw new LoginException("Enter Valid Password");
		}
	}

	@Override
	public String logoutAdminAccount(String uuid) throws LogoutException {
		Optional<CurrentAdminSession> currAdminOpt = adminSessionRepo.findByUuid(uuid);

		if (currAdminOpt.isPresent()) {
			CurrentAdminSession currAdmin1 = currAdminOpt.get();

			adminSessionRepo.delete(currAdmin1);
			return "Admin logged out successfully.";
		}
		throw new LogoutException("Admin does not exist, Enter correct uuid");
	}

}
