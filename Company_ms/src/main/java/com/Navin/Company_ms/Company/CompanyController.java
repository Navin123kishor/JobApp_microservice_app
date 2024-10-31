package com.Navin.Company_ms.Company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Navin.Company_ms.DTO.CompanyDTO;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private CompanyService companyservice;
	public CompanyController( CompanyService service) {
		this.companyservice = service;
	}
	
//	@GetMapping
//	public ResponseEntity<List<Company>> getAllCompany() {
//	        List<Company> list = this.companyservice.findAllCompany();
//
//	        if (list == null || list.isEmpty()) {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	        return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	@GetMapping
	public ResponseEntity<List<CompanyDTO>> getAllCompany() {
	        List<CompanyDTO> list = this.companyservice.findAllCompanyDTO();

	        if (list == null || list.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> UpdateCompany(@PathVariable("id") long id,
			 @RequestBody Company company){
		
		try {
			this.companyservice.UpDateCompany(company, id);
			return new ResponseEntity<>( "Updated Successfully", HttpStatus.OK);
	    }catch(Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> CreateCompany(@RequestBody Company comp){
		
		try {
			this.companyservice.CreateCompany(comp);
			return new ResponseEntity<>("Company Added successfully", HttpStatus.CREATED);
		}catch( Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteCompany(@PathVariable("id") long companyId){
		
		boolean deleted = this.companyservice.DeleteCompany(companyId);
		if( deleted == true) {
			return new ResponseEntity<>(" Company Deleted Successfully !", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id")long companyid){
		
		Company curr_comp = this.companyservice.getCompany(companyid);
		if( curr_comp != null) {
			return new ResponseEntity<>(curr_comp, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
 }
