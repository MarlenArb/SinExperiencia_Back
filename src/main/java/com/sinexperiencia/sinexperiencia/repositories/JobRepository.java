package com.sinexperiencia.sinexperiencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinexperiencia.sinexperiencia.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Long>{

}
