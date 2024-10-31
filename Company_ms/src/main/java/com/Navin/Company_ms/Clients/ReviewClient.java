package com.Navin.Company_ms.Clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Navin.Company_ms.External.Review;

@FeignClient(name="REVIEW-SERVICE")
public interface ReviewClient {

	@GetMapping("/reviews")
    List<Review> getReviews(@RequestParam("company_id") Long company_id);
	
}
