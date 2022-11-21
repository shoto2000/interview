package com.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entity.AdminSignin;

public interface AdminRepo extends JpaRepository<AdminSignin, Integer>{
	public Optional<AdminSignin> findByMobileNo(String mobileNo);
}
