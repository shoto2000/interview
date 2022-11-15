package com.prospecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.entity.Prospecta;
import com.prospecta.repository.ProspectsRepository;

@Service
public class ProspectaServiceImpl implements ProspectService{

	@Autowired
	private ProspectsRepository prospectaRepo;
	
	@Override
	public List<Prospecta> getProspectaByCategory(String category) throws Exception{
		List<Prospecta> prospecta = prospectaRepo.findByCategory(category);
		
		if(prospecta.size()>0) {
			return prospecta;
		}
		else {
			throw new Exception("no details available with this category name: "+ category);
		}
	}

	@Override
	public Prospecta savePeospecta(Prospecta prospecta) {
		return prospectaRepo.save(prospecta);
	}

}
