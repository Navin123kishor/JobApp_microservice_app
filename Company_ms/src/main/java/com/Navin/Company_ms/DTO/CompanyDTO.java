package com.Navin.Company_ms.DTO;

import java.util.List;

import com.Navin.Company_ms.Company.Company;
import com.Navin.Company_ms.External.Job;
import com.Navin.Company_ms.External.Review;

public class CompanyDTO {

	Company company;
	List<Job> jobs;
	List<Review> reviews;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
