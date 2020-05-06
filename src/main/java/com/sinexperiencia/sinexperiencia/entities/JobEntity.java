package com.sinexperiencia.sinexperiencia.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sinexperiencia.sinexperiencia.enums.Enums;

import lombok.Data;

@Entity
@Table(name = "JOBS_TABLE")
@Data
public class JobEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SEQUENCENAME")
	@Column(name = "ID")
	private Long idJob;
	
	@Column(name = "PROFESION")
	private  String occupation;
	
	@Column(name = "DESCRIPCION")
	private String description;
	
	//@Column(name = "REQUISITOS")
	//private List<String> requirements;
	
	@Column(name = "EMPRESA")
	private String company;
	
}
