package com.Navin.Job_ms.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Navin.Job_ms.dto.JobDTO;

@RestController
public class JobController {
	
	private JobService jobservice; // This make controller dependent on interface not on impl;
	 
	public JobController(JobService jobservice) {
		this.jobservice = jobservice;
	}
	
//	@GetMapping("/jobs")
//	public ResponseEntity< List<Job>> getAllJobs(){
//		List<Job> list = this.jobservice.findAllJobs();
//		if( list == null || list.size() == 0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(list));
//	}
	
	@GetMapping("/alljobs/enternal")
	public ResponseEntity< List<Job>> getAllJobs(){
	List<Job> list = this.jobservice.findAllJobs();
	if( list == null || list.size() == 0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(list));
}
	
	
	@GetMapping("/jobs")
	public ResponseEntity<List<JobDTO>> getJobAndCompany(){
		System.out.println(" Request for Jobs is send from Controller! ");
		
		List<JobDTO> job_com_list = this.jobservice.findAllJobs_Company();
		System.out.println(" Recieved the Jobs details in Controller");
		System.out.println("Job list size "+ job_com_list.size());
		
		if( job_com_list == null) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>( job_com_list , HttpStatus.OK);
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<String> Save(@RequestBody Job job) {
		if( job == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
		    Job added  =	(Job)this.jobservice.AddJob(job);
			return ResponseEntity.of(Optional.of("job added successfullly"));
		}
		catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
//		Job added_job = (Job)this.jobservice.AddJob(job);
//		if( added_job == null) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return ResponseEntity.of(Optional.of("job added successfullly"));
		
	}
	
	@GetMapping("/jobs/{jobid}")
	public ResponseEntity<JobDTO> getJobById(@PathVariable("jobid") long jId) {
		
		JobDTO job_comp = this.jobservice.GetJobById(jId);
		if( job_comp != null)
			 //return ResponseEntity.of(Optional.of( job));
			 return new ResponseEntity<>(job_comp, HttpStatus.OK);
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/jobs/{jobid}")
	public ResponseEntity<String> DeleteJobById(@PathVariable("jobid") Long id){
		
		boolean deleted = this.jobservice.DeleteById( id);
		if( deleted == true) {
			return new ResponseEntity<>("Job deleted with ID "+ id , HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
