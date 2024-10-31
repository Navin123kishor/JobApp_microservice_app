package com.Navin.Review_ms.Review;

import java.util.List;

public interface ReviewService {

	public List<Review> getAllReview(long companyid);
	public boolean AddReview( Long c_id, Review rev);
	public Review getReview( long rev_id);
	
	public boolean updateReview(Review rev,  Long rev_id);
	
	public boolean DeleteReview( long rev_id);
}
