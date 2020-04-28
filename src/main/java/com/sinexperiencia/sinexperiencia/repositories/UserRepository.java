package com.sinexperiencia.sinexperiencia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinexperiencia.sinexperiencia.entities.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public Optional<UserEntity> findByName(String username);
	public Optional<UserEntity> findByMail(String email);
}
