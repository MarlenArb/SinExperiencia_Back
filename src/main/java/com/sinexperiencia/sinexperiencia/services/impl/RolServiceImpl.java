package com.sinexperiencia.sinexperiencia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinexperiencia.sinexperiencia.converters.DtoToEntity;
import com.sinexperiencia.sinexperiencia.converters.EntityToDto;
import com.sinexperiencia.sinexperiencia.dtos.RolDto;
import com.sinexperiencia.sinexperiencia.repositories.RolRepository;
import com.sinexperiencia.sinexperiencia.services.RolService;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	EntityToDto etd;

	@Autowired
	DtoToEntity dte;

	@Override
	@Transactional(readOnly = true)
	public RolDto getRol(Long id) {
		List<RolDto> list = etd.getRol(rolRepository.findAll());
		return list.get(0);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RolDto> getRoles() {
		return etd.getRol(rolRepository.findAll());
	}

}
