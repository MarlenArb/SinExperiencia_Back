package com.sinexperiencia.sinexperiencia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinexperiencia.sinexperiencia.dtos.JobDto;

@Service
public interface JobService {
	
	public JobDto getJob(Long id);
	public void loadJobs(List<JobDto> jobs);
	public void addJob(JobDto user);
	public void deleteJob(Long id);
	public List<JobDto> getJobs();
	public JobDto modifyJob(Long id, JobDto user);

}
