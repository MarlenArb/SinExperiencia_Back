package com.sinexperiencia.sinexperiencia.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.sinexperiencia.sinexperiencia.converters.EntityToDto;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;

@Service
public class EntityToDtoImpl implements EntityToDto {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public UserDto getUser(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setIdUser(userEntity.getIdUser());
		userDto.setName(userEntity.getName());
		userDto.setPassword(encoder.encode(userEntity.getPassword()));
		userDto.setMail(userEntity.getMail());
		userDto.setBirthdate(userEntity.getBirthdate());
		userDto.setCountry(userEntity.getCountry());
		//userDto.setRol(getRol(userEntity.getRoles()).get(0)); TODO: Rol
		return userDto;
	}
}
