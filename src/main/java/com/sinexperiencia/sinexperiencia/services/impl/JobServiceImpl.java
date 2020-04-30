package com.sinexperiencia.sinexperiencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinexperiencia.sinexperiencia.converters.DtoToEntity;
import com.sinexperiencia.sinexperiencia.converters.EntityToDto;
import com.sinexperiencia.sinexperiencia.dtos.JobDto;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.JobEntity;
import com.sinexperiencia.sinexperiencia.entities.RolEntity;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;
import com.sinexperiencia.sinexperiencia.exceptions.UserNoContentException;
import com.sinexperiencia.sinexperiencia.exceptions.messages.DataErrorMessages;
import com.sinexperiencia.sinexperiencia.repositories.JobRepository;
import com.sinexperiencia.sinexperiencia.repositories.RolRepository;
import com.sinexperiencia.sinexperiencia.repositories.UserRepository;
import com.sinexperiencia.sinexperiencia.services.JobService;

@Service
public class JobServiceImpl implements JobService{

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private List<UserDto> jobsDtos = new ArrayList<>();

	@Autowired
	private JobRepository jobRepository;

	
	@Autowired
	private RolRepository rolRepository;
	

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	EntityToDto etd;

	@Autowired
	DtoToEntity dte;


	@Override
	@Transactional
	public void addJob(JobDto job) {

		JobEntity j = dte.getJob(job);
		jobRepository.save(j);

	}


	@Override
	@Transactional
	public JobDto modifyJob(Long id, JobDto job) {

		JobEntity j = jobRepository.findById(id).orElseThrow(() -> {
			logger.warn(DataErrorMessages.JOB_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.JOB_NO_CONTENT);
		});

		j = dte.getJob(job);
		
//		u.setName(user.getName());
//		u.setBirthdate(user.getBirthdate());
//		u.setPassword(encoder.encode(user.getPassword()));
//		u.setCountry(user.getCountry());
//		u.setMail(user.getMail());
//		u.setLastname(user.getLastname());
//		u.setExperience(user.getExperience());
//		u.setOccupation(user.getOccupation());

		jobRepository.save(j);

		return job;

	}


	@Override
	@Transactional
	public void deleteJob(Long id) {

		JobEntity j = jobRepository.findById(id).orElseThrow(() -> {
			logger.warn(DataErrorMessages.USER_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.USER_NO_CONTENT);
		});

		jobRepository.delete(j);

	}

	@Override
	@Transactional(readOnly = true)
	public List<JobDto> getJobs() {

		List<JobEntity> jobEntities = jobRepository.findAll();
		List<JobDto> jobDtos = new ArrayList<>();

		for (JobEntity j : jobEntities)
			jobDtos.add(etd.getJob(j));
		
		return jobDtos;

	}

	@Override
	public JobDto getJob(Long id) {

		return etd.getJob(jobRepository.findById(id).orElseThrow(() -> {
			logger.warn(DataErrorMessages.JOB_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.JOB_NO_CONTENT);
		}));

	}



	//Carga inicial de usuarios
	@Override
	public void loadJobs(List<JobDto> jobs) {
		for (JobDto j : jobs) {
			jobRepository.save(dte.getJob(j));
		}
	}
}
