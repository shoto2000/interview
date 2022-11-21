package com.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entity.CurrentAdminSession;

public interface AdminSessionRepo extends  JpaRepository<CurrentAdminSession, Integer>{
	public Optional<CurrentAdminSession> findByUuid(String uuid);
	
	public Optional<CurrentAdminSession> findByAdminId(Integer userId);
}