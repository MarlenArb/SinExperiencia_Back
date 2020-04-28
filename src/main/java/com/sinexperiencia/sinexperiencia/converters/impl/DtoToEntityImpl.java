package com.sinexperiencia.sinexperiencia.converters.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sinexperiencia.sinexperiencia.dtos.RolDto;
import com.sinexperiencia.sinexperiencia.entities.RolEntity;
import com.sinexperiencia.sinexperiencia.converters.DtoToEntity;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;

@Service
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
		userEntity.setRoles(getRol(userDto.getRol()));
		

		return userEntity;
	}

	@Override
	public List<RolEntity> getRol(RolDto rolDto) {

		List<RolEntity> lista = new ArrayList<RolEntity>();

		RolEntity rolEntity = new RolEntity();
		rolEntity.setName(rolDto.getName().toString());
		lista.add(rolEntity);

		return lista;

	}

}