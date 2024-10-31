package com.Navin.Review_ms.Review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private ReviewService revService;
	
	public ReviewController( ReviewService revS) {
		this.revService = revS;
	}
	 
	@GetMapping
	public ResponseEntity<List<Review>> getReviews(@RequestParam long company_id){
		
		List<Review> reviews = this.revService.getAllReview(company_id);
		if( reviews != null && reviews.size() != 0) {
			return new ResponseEntity<>( reviews, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<String> AddReview(@RequestBody Review rev, @RequestParam long company_id ){
		
		boolean add = this.revService.AddReview(company_id , rev);
		if( add == true) {
			return new ResponseEntity<>("Review Added Successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/{reviewid}")
	public ResponseEntity<Review> getReviewByID( @PathVariable("reviewid") long rev_id){
		
		Review rev = this.revService.getReview( rev_id);
		if( rev  == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(rev, HttpStatus.OK);
	}
	
	@PutMapping("/{review_id}")
	public ResponseEntity<String> UpdateReview(@RequestBody Review New_Review,
			                                   @PathVariable("review_id") long rev_id){
		System.out.println( " value of revid from url = "+ rev_id);
		boolean updated = this.revService.updateReview( New_Review, rev_id);
		if( updated == true) {
			return new ResponseEntity<>("Review updated Successfully !", HttpStatus.OK);
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{review_id}")
	public ResponseEntity<String> DeleteReview( @PathVariable("review_id")long rev_id){
		
		boolean isDelete = this.revService.DeleteReview( rev_id);
		if( isDelete == true) {
			return new ResponseEntity<>("Review Deleted !", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
