package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.entity.Job;
import com.jspiders.springboot.service.JobService;

@RestController
@RequestMapping(path = "api/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping
	protected Job addJob(@RequestBody Job job) {
		return jobService.addJob(job);
	}

	@GetMapping
	protected List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}

	@PutMapping("/{id}")
	protected Job updateJob(@PathVariable Integer id, @RequestBody Job job) {
		return jobService.updateJob(id, job);
	}

	@DeleteMapping("/{id}")
	protected void deleteJob(@PathVariable Integer id) {
		jobService.deleteJob(id);
	}
	
	@GetMapping("/search")
	protected List<Job> search(@RequestParam String keyword) {
		return jobService.search(keyword);
	}
}
