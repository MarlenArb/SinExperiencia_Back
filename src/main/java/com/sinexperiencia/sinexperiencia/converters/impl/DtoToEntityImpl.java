package com.sinexperiencia.sinexperiencia.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sinexperiencia.sinexperiencia.converters.DtoToEntity;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;

public class DtoToEntityImpl implements DtoToEntity {
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public UserEntity getUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		if (userDto.getIdUser() != null) {
			userEntity.setIdUser(userDto.getIdUser());
		}
		userEntity.setName(userDto.getName());
		userEntity.setLastname(userDto.getLastname());
		userEntity.setOccupation(userDto.getOccupation());
		userEntity.setExperience(userDto.getExperience());
		userEntity.setPassword(encoder.encode(userDto.getPassword()));
		userEntity.setMail(userDto.getMail());
		userEntity.setBirthdate(userDto.getBirthdate());
		userEntity.setCountry(userDto.getCountry());
		//userEntity.setRoles(getRol(userDto.getRol())); TODO: Rol
		

		return userEntity;
	}

}
