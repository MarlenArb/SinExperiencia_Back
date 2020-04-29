package com.sinexperiencia.sinexperiencia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinexperiencia.sinexperiencia.dtos.RolDto;

@Service
public interface RolService {
	
	public RolDto getRol(Long id);
	public List<RolDto> getRoles();

}

