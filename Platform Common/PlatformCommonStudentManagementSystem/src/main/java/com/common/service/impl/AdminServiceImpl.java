package com.common.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.entity.AdminSignin;
import com.common.exception.SigninException;
import com.common.repository.AdminRepo;
import com.common.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public AdminSignin createAdmin(AdminSignin user) throws SigninException {
		Optional<AdminSignin> opt = adminRepo.findByMobileNo(user.getMobileNo());

		if (opt.isPresent()) {
			throw new SigninException("User already Exist");
		}
		return adminRepo.save(user);
	}

}
