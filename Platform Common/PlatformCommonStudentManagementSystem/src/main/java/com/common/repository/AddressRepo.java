package com.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
