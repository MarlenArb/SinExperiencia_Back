package com.sinexperiencia.sinexperiencia.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.sinexperiencia.sinexperiencia.entities.UserEntity;

import lombok.Data;

@Entity
@Table(name = "USERS_ROLES")
@Data
public class RolEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ID_ROL")
	@Column(name = "ID")
	private Long idRol;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UserEntity> users = new ArrayList<UserEntity>();

}
