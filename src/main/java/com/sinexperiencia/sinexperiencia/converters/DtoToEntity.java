package com.sinexperiencia.sinexperiencia.converters;

import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;

public interface DtoToEntity{

	public UserEntity getUser(UserDto userDto);
}
