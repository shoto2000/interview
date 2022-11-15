package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.entity.Prospecta;
import com.prospecta.service.ProspectaServiceImpl;

@RestController
public class ProspectaController {
	
	@Autowired
	private ProspectaServiceImpl prosSerImp;
	
	@GetMapping("/prospecta/{name}")
	public List<Prospecta> getProspectaByCategoryHandler(@PathVariable String name) throws Exception {
	
		return  prosSerImp.getProspectaByCategory(name);
		
	}
	
	@PostMapping("/prospecta")
	public ResponseEntity<Prospecta> registerProspectaHandler(@RequestBody Prospecta prospecta) {
		
		Prospecta pros = prosSerImp.savePeospecta(prospecta);
		
		return new ResponseEntity<Prospecta>(pros, HttpStatus.CREATED);
		
	}
}
