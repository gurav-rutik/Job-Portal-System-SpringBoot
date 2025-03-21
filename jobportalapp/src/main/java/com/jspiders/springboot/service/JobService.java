package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.entity.Job;
import com.jspiders.springboot.repository.JobRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;

	public Job addJob(Job job) {
		return jobRepository.save(job);
		
	}

	public List<Job> getAllJobs() {
		return jobRepository.findAll();
		
	}

	public Job updateJob(Integer id, Job updatedJob) {
		Optional<Job> optionalJob = jobRepository.findById(id);
		
		if(optionalJob.isPresent()) {
			Job job = optionalJob.get();
			
			job.setJobProfile(updatedJob.getJobProfile());
			job.setJobDescription(updatedJob.getJobDescription());
			job.setReqExperience(updatedJob.getReqExperience());
			job.setReqSkills(updatedJob.getReqSkills());
			
			return jobRepository.save(job);
		}else {
			throw new RuntimeException("Job not found!");
		}
	}

	public void deleteJob(Integer id) {
		jobRepository.deleteById(id);
		
	}

	public List<Job> search(String keyword) {
		return jobRepository.search(keyword);
		
	}
}
