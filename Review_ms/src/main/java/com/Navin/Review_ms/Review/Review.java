package com.Navin.Review_ms.Review;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

	@Id
	private long id;
	private String title;
	private String description;
	private double rating;
	private long companyId;
	
	
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(long id, String title, String description, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}
	

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", description=" + description + ", rating=" + rating + "]";
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
