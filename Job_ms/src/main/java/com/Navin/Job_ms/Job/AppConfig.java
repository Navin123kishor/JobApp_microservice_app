package com.Navin.Job_ms.Job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// This is class configured for load balanacer in Service registery. 
// NOw this resttemplate can be use dto fetch the service regisetred in service regsitry
@Configuration
public class AppConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
