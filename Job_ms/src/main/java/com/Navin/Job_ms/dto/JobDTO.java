package com.Navin.Job_ms.dto;

import java.util.List;

import com.Navin.Job_ms.Job.Job;

import external.Company;
import external.Review;

public class JobDTO {

	private Company company;
	private Job job;
	private List<Review> reviews;
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
}
