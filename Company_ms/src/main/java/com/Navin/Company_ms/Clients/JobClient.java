package com.Navin.Company_ms.Clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.Navin.Company_ms.External.Job;

@FeignClient(name="JOB-SERVICE")
public interface JobClient {
	
	@GetMapping("/alljobs/enternal")
	public List<Job> getAllJobs();
	
}

