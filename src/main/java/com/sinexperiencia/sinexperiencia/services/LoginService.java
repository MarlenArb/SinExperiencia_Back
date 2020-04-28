package com.sinexperiencia.sinexperiencia.services;

import java.util.Optional;

import com.sinexperiencia.sinexperiencia.entities.UserEntity;



public interface LoginService {

	public Optional<UserEntity> findByUsername(String username);
}
