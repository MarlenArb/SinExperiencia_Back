package com.sinexperiencia.sinexperiencia.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinexperiencia.sinexperiencia.dtos.RolDto;

import lombok.Data;

@Data
public class UserDto {

	private Long idUser;

	private String name;
	
	private String lastname;

	private String password;

	private String mail;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private String birthdate;

	private String occupation;
	
	private String experience;
	
	private String country;
	
	private RolDto rol;
	
}
