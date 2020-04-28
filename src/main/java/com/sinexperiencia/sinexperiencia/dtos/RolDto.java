package com.sinexperiencia.sinexperiencia.dtos;



import com.sinexperiencia.sinexperiencia.enums.Enums;

import lombok.Data;

@Data
public class RolDto {
	
	private long id;
	
	private Enums.rolUser name;

}