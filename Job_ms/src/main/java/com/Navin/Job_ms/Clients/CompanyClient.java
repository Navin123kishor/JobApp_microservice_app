package com.Navin.Job_ms.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import external.Company;

@FeignClient(name="COMPANY-SERVICE")
public interface CompanyClient {
	@GetMapping("/company/{id}")
	Company getCompany(@PathVariable("id") Long id);
}
