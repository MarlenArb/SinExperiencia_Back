package com.sinexperiencia.sinexperiencia.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Table(name = "USERS_TABLE")
@Data
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ID_GAME_USER")
	@Column(name = "ID")
	private Long idUser;

	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "APELLIDO")
	private String lastname;

	@Column(name = "CONTRASEÑA")
	private String password;

	@Column(name = "EMAIL")
	private String mail;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "F.NACIMIENTO")
	private String birthdate;

	@Column(name = "PROFESIÓN")
	private String occupation;
	
	@Column(name = "EXPERIENCIA")
	private String experience;
	
	@Column(name = "PAIS")
	private String country;

}
