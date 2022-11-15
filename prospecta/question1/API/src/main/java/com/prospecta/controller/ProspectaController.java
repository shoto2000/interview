package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.entity.Prospecta;
import com.prospecta.service.ProspectaServiceImpl;

@RestController
public class ProspectaController {
	
	@Autowired
	private ProspectaServiceImpl prosSerImp;
	
	@GetMapping("/getprospectabycategory/{name}")
	public List<Prospecta> getProspectaByCategoryHandler(@PathVariable String name) throws Exception {
	
		return  prosSerImp.getProspectaByCategory(name);
		
	}
}
