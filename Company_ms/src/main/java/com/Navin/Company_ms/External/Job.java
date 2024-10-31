package com.Navin.Company_ms.External;

public class Job {

	long id;
	String title;
	String description;
	String minSalary;
	String maxSalary;
	String location;
	long companyId;
	
	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", minSalary=" + minSalary
				+ ", maxSalary=" + maxSalary + ", location=" + location + ", companyId=" + companyId + "]";
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
