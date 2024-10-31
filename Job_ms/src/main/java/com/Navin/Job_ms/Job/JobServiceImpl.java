package com.Navin.Job_ms.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Navin.Job_ms.Clients.CompanyClient;
import com.Navin.Job_ms.Clients.ReviewClient;
import com.Navin.Job_ms.dto.JobDTO;

import external.Company;
import external.Review;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private RestTemplate resttemp;
	
	private JobRespository jobrepo ;
	
	// create a object of CompanyClient to call its method
	CompanyClient companyClient; 
	// Review CLient object
	ReviewClient reviewClient;
	
	public JobServiceImpl( JobRespository repo , CompanyClient c_client, ReviewClient rev_client) {
		this.jobrepo = repo;
		this.companyClient = c_client;
		this.reviewClient = rev_client;
	}
	
	//It was only for JObs , Now we will require to have JobwithCompanyDTo objects
	@Override
	public List<Job> findAllJobs() {
		// TODO Auto-generated method stub
		
		// for demonstartion of RestTemplate use 
//		System.out.println( " Start of findAll Jobs !");
//		RestTemplate restTemp = new RestTemplate();
//		Company comp = restTemp.getForObject("http://localhost:8081/company/1", Company.class);
//		
//		System.out.println("COMPANY NAME : "+ comp.getName());
//		System.out.println("COMPANY ID : "+ comp.getId());
		
			
		return this.jobrepo.findAll();
	}

	@Override
	public List<JobDTO> findAllJobs_Company() {
		// TODO Auto-generated method stub
		
		System.out.println(" Request is in serviceImple");
		List<Job> jobs = this.jobrepo.findAll();
		List<JobDTO> job_dto_list = new ArrayList<>();
				
		System.out.println(" Jobs list size "+ jobs.size());
		
		for( Job job: jobs) {
			System.out.println( job.toString()+ " companyId= "+ job.getCompanyId());
			JobDTO jobdto = ConvertToJobDTO( job);
			
			job_dto_list.add( jobdto);
		}
				
		return job_dto_list;
	}
	
	@Override
	public Job AddJob(Job job) {
		// TODO Auto-generated method stub
	    return this.jobrepo.save(job);
	   
	}

	@Override
	public JobDTO GetJobById(Long id) {
		// TODO Auto-generated method stub
		Optional<Job> opt = this.jobrepo.findById(id);
		Job job = null;
		
		try {
			job = opt.get();
		}
		catch(Exception e) {
			return null;
		}
		System.out.println("Job in ServiceImpl :"+ job.toString());
		return ConvertToJobDTO(job);
	}

	@Override
	public boolean DeleteById(Long id) {
		// TODO Auto-generated method stub
		try {
		   this.jobrepo.deleteById(id);
		   return true;
		}catch( Exception e) {
			return false;
		}
	}
	public JobDTO ConvertToJobDTO( Job job) {
//		JobDTO job_dto = new JobDTO();
//		Company company = null;
//		try {
//			String url = "http://COMPANY_MS:8081/company/" + job.getCompanyId();
//			company = resttemp.getForObject(url, Company.class);
//			System.out.println("Company for jobid "+job.getId() +" is : "+ company);
//			
//			ResponseEntity<List<Review>>reviewResponse = resttemp.exchange("http://REVIEW_MS:8083/reviews?company_id="+job.getCompanyId(), 
//					HttpMethod.GET, null , new ParameterizedTypeReference<List<Review>>() {
//			       } );
//			
//			List<Review> reviewList = reviewResponse.getBody();
//			
//			job_dto.setJob(job);
//			job_dto.setCompany(company);
//			job_dto.setReviews(reviewList);
//		}
//		catch(Exception e) {
//			System.out.println("Company could retrived corresponding to Job");
//			System.out.println(e.toString());
//			return null;
//		}
//		return job_dto;
		
		
		// Use Open-Fiegn Company client to fetch company 
		Company company = this.companyClient.getCompany(job.getCompanyId());
		List<Review> review_list = this.reviewClient.getReviews(company.getId());
		
		JobDTO job_dto = new JobDTO();
		job_dto.setCompany(company);
		job_dto.setReviews(review_list);
		job_dto.setJob(job);
		
		return job_dto;
	}

}
