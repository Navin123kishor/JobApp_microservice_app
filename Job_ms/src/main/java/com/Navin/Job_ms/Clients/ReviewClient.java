package com.Navin.Job_ms.Clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import external.Company;
import external.Review;

@FeignClient(name="REVIEW-SERVICE")
public interface ReviewClient {
	@GetMapping("/reviews")
    List<Review> getReviews(@RequestParam("company_id") Long company_id);
}
