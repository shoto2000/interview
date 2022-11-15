package com.prospecta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.entity.Prospecta;

@Repository
public interface ProspectsRepository extends JpaRepository<Prospecta, Integer>{
	public List<Prospecta> findByCategory(String name);
}
