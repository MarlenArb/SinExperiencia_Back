package com.sinexperiencia.sinexperiencia.converters.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sinexperiencia.sinexperiencia.dtos.RolDto;
import com.sinexperiencia.sinexperiencia.entities.RolEntity;
import com.sinexperiencia.sinexperiencia.enums.Enums;
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
		userDto.setExperience(userEntity.getExperience());
		userDto.setLastname(userEntity.getLastname());
		userDto.setOccupation(userEntity.getOccupation());
		userDto.setCountry(userEntity.getCountry());
		userDto.setRol(getRol(userEntity.getRoles()).get(0));
		return userDto;
	}
	
	@Override
	public List<RolDto> getRol(List<RolEntity> rolEntity) {

		List<RolDto> lista = new ArrayList<RolDto>();

		for (RolEntity r : rolEntity) {
			RolDto rolDto = new RolDto();
			rolDto.setName(Enums.rolUser.valueOf(r.getName()));
			lista.add(rolDto);
		}

		return lista;

	}
}
