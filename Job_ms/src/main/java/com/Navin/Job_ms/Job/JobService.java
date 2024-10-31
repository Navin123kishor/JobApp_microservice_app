package com.Navin.Job_ms.Job;

import java.util.List;

import com.Navin.Job_ms.dto.JobDTO;

public interface JobService {

	List<Job> findAllJobs();
	List<JobDTO> findAllJobs_Company();
	Job AddJob(Job job);
	JobDTO GetJobById( Long id);
	//Job GetJobById(Long id);
	
	boolean DeleteById( Long id);
}
