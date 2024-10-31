package com.Navin.Company_ms.Company;

import java.util.List;

import com.Navin.Company_ms.DTO.CompanyDTO;

public interface CompanyService {

	List<Company> findAllCompany();
	List<CompanyDTO> findAllCompanyDTO();
	
	boolean UpDateCompany( Company company, Long id);
	
	boolean CreateCompany( Company comp);
	
	boolean DeleteCompany( Long id);
	
	Company getCompany( Long id);
}
