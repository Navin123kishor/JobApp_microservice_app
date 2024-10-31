package com.Navin.Review_ms.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review , Long>{

	// create a custom finder to get review based on company id
	List<Review> findByCompanyId(long companyid);
	
}
