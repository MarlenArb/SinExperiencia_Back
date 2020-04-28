package com.sinexperiencia.sinexperiencia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinexperiencia.sinexperiencia.entities.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
	
	public Optional<RolEntity> findByName(String name);
	
}
