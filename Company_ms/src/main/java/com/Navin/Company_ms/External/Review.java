package com.Navin.Company_ms.External;

public class Review {

	private long id;
	private String title;
	private String description;
	private double rating;
	private long companyId;
	
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", description=" + description + ", rating=" + rating
				+ ", companyId=" + companyId + "]";
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
