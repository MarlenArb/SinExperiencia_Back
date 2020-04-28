package com.sinexperiencia.sinexperiencia.converters;

import java.util.List;

import com.sinexperiencia.sinexperiencia.dtos.RolDto;
import com.sinexperiencia.sinexperiencia.entities.RolEntity;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;

public interface EntityToDto {
	
	public UserDto getUser(UserEntity userEntity);
	public List<RolDto> getRol(List<RolEntity> rolEntity);

}
