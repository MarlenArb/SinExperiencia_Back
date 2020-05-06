package com.sinexperiencia.sinexperiencia.dtos;

import java.util.List;

import com.sinexperiencia.sinexperiencia.enums.Enums;

import lombok.Data;

@Data
public class JobDto {

	private Long idJob;
	private  Enums.occupations occupation;
	private String description;
	//private List<String> requirements;
	private String company;
	//TODO: Añadir fecha creacion automatica (mirar videos)
	
}
