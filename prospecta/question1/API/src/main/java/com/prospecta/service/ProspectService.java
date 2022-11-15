package com.prospecta.service;

import java.util.List;

import com.prospecta.entity.Prospecta;

public interface ProspectService {
	public List<Prospecta> getProspectaByCategory(String name) throws Exception;
}
