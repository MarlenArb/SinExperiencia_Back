package com.sinexperiencia.sinexperiencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinexperiencia.sinexperiencia.dtos.JobDto;
import com.sinexperiencia.sinexperiencia.services.impl.JobServiceImpl;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobServiceImpl jobService;
	
	// GET
	@GetMapping("/{id}")
	public JobDto getJob(@Validated @PathVariable Long id) {
		return jobService.getJob(id);
	}
	
	//CARGA INICIAL
	@PostMapping("/loadJobs")
	public void loadJobs(@Validated @RequestBody List<JobDto> jobs) {
		jobService.loadJobs(jobs);
	};
		

	// POST
	@PostMapping
	public void addJob(@Validated @RequestBody JobDto job) {
		jobService.addJob(job);
	};

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteJob(@PathVariable Long id) {
		jobService.deleteJob(id);
	}

	// GET
	@GetMapping
	public List<JobDto> getJobs() {
		return jobService.getJobs();
	}

	// PUT
	@PutMapping("/{id}")
	public JobDto modifyJob(@Validated @PathVariable Long id, @Validated @RequestBody JobDto job) {
		return jobService.modifyJob(id, job);
	}

}
