package com.sinexperiencia.sinexperiencia.converters;

import java.util.List;

import com.sinexperiencia.sinexperiencia.dtos.JobDto;
import com.sinexperiencia.sinexperiencia.dtos.RolDto;
import com.sinexperiencia.sinexperiencia.entities.JobEntity;
import com.sinexperiencia.sinexperiencia.entities.RolEntity;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;

public interface DtoToEntity{

	public UserEntity getUser(UserDto userDto);
	public List<RolEntity> getRol(RolDto rolDto);
	public JobEntity getJob(JobDto jobDto);
}
