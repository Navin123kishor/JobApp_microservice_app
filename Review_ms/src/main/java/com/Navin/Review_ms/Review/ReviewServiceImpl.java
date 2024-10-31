package com.Navin.Review_ms.Review;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewRepository revRepo;
	
	public ReviewServiceImpl(ReviewRepository repo) {
		this.revRepo = repo;
	}

	@Override
	public List<Review> getAllReview(long companyid) {
		// TODO Auto-generated method stub
		List<Review> reviews = this.revRepo.findByCompanyId(companyid);
		return reviews;
	}

	@Override
	public boolean AddReview(Long c_id, Review rev) {
		// TODO Auto-generated method stub
		
		if( c_id != null && rev != null) {
			rev.setCompanyId(c_id);
			this.revRepo.save(rev);
			//this.compservice.UpDateCompany(curr_comp, c_id);
			return true;
		}
		return false;
	}

	@Override
	public Review getReview(long rev_id) {
		// TODO Auto-generated method stub
		return this.revRepo.findById(rev_id).orElse(null);
	}

	@Override
	public boolean updateReview(Review updated_rev , Long rev_id) {
		// TODO Auto-generated method stub
		System.out.println( " value of revid in impl = "+ rev_id);

		Review old_rev = this.revRepo.findById(rev_id).orElse(null);
		System.out.println( " value of revid in impl = "+ rev_id);

		if( old_rev != null ) {
			old_rev.setId(updated_rev.getId());
			old_rev.setTitle(updated_rev.getTitle());
			old_rev.setRating(updated_rev.getRating());
			old_rev.setDescription(updated_rev.getDescription());
			old_rev.setCompanyId(updated_rev.getCompanyId());
			
			System.out.println("updatedRev = "+  old_rev.toString());
			this.revRepo.save(old_rev);
			System.out.println( " value of revid in impl = "+ rev_id);
			return true;
		}
		System.out.println( "returning false now, value of revid in impl = "+ rev_id);
		return false;
	}

	@Override
	public boolean DeleteReview( long rev_id) {
		// TODO Auto-generated method stub
		
		Review rev = this.revRepo.findById(rev_id).orElse(null);
		if(rev != null ) {
			this.revRepo.deleteById(rev_id);
			return true;
		}
		return false;
	}

}
