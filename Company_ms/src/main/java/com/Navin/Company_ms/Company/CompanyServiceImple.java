package com.Navin.Company_ms.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Navin.Company_ms.Clients.JobClient;
import com.Navin.Company_ms.Clients.ReviewClient;
import com.Navin.Company_ms.DTO.CompanyDTO;
import com.Navin.Company_ms.External.Job;
import com.Navin.Company_ms.External.Review;


@Service
public class CompanyServiceImple implements CompanyService {

	private CompanyRepository companyrepo;
	
	private JobClient jobClient;
	private ReviewClient reviewClient;
	
	public CompanyServiceImple(CompanyRepository repo , ReviewClient revClient , JobClient jclient  ) {
		this.companyrepo = repo;
		this.jobClient = jclient;
		this.reviewClient = revClient;
	}

	@Override
	public List<Company> findAllCompany() {
		// TODO Auto-generated method stub
		return this.companyrepo.findAll();
	}
	
	@Override
	public List<CompanyDTO> findAllCompanyDTO() {
		// TODO Auto-generated method stub
		List<Company> company_list = this.companyrepo.findAll();
		
		List<Job> all_job_list = this.jobClient.getAllJobs();
		
		List<CompanyDTO> companyDTO_list = new ArrayList<>();
		
		for( Company comp : company_list) {
			List<Job> jobs_list = new ArrayList<>();
			
			for( Job job : all_job_list) {
				if( job.getCompanyId() == comp.getId()) {
					jobs_list.add( job);
				}
			}
			
			List<Review> review_list = this.reviewClient.getReviews(comp.id);
			
			CompanyDTO cdto = new CompanyDTO();
			cdto.setCompany(comp);
			cdto.setJobs(jobs_list);
			cdto.setReviews(review_list);
			companyDTO_list.add(cdto);
		}
		return companyDTO_list ;
	}

	@Override
	public boolean UpDateCompany(Company company, Long id) {
		// TODO Auto-generated method stub
		try {
		  Optional<Company> opt = this.companyrepo.findById(id);
		  Company comp = opt.get();
		  
		  comp.setId(id);
		  comp.setName(company.getName());
		  comp.setDescription(company.getDescription());
		  
		  this.companyrepo.save(comp);
		  return true;
		
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean CreateCompany(Company comp) {
		// TODO Auto-generated method stub
		try {
		  this.companyrepo.save( comp);
		  return true;
	   }catch(Exception e) {
		   return false;
	   }
	}

	@Override
	public boolean DeleteCompany(Long id) {
		// TODO Auto-generated method stub
		if(this.companyrepo.existsById(id)) {
			this.companyrepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompany(Long id) {
		// TODO Auto-generated method stub
		return this.companyrepo.findById(id).orElse(null);
	}

}
