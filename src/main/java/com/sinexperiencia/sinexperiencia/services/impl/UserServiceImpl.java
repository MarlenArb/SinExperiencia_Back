package com.sinexperiencia.sinexperiencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinexperiencia.sinexperiencia.converters.DtoToEntity;
import com.sinexperiencia.sinexperiencia.converters.EntityToDto;
import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.entities.RolEntity;
import com.sinexperiencia.sinexperiencia.entities.UserEntity;
import com.sinexperiencia.sinexperiencia.exceptions.UserNoContentException;
import com.sinexperiencia.sinexperiencia.exceptions.messages.DataErrorMessages;
import com.sinexperiencia.sinexperiencia.repositories.RolRepository;
import com.sinexperiencia.sinexperiencia.repositories.UserRepository;
import com.sinexperiencia.sinexperiencia.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private List<UserDto> usersDtos = new ArrayList<>();

	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private RolRepository rolRepository;
	

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	EntityToDto etd;

	@Autowired
	DtoToEntity dte;

	// addUser: Añade un nuevo usuario a la BBDD
	@Override
	@Transactional
	public void addUser(UserDto user) {

		UserEntity u = dte.getUser(user);

		System.out.println(user.getRol().getName().toString());

		RolEntity r = rolRepository.findByName(user.getRol().getName().toString()).orElseThrow(() -> {
			logger.warn(DataErrorMessages.ROLE_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.ROLE_NO_CONTENT);
		}); 

		r.getUsers().add(u);


		userRepository.save(u);

	}

	// modifyUser: Modifica los datos de un usuario, pasando su id y los nuevos
	// datos por parámetro
	@Override
	@Transactional
	public UserDto modifyUser(Long id, UserDto user) {

		UserEntity u = userRepository.findById(id).orElseThrow(() -> {
			logger.warn(DataErrorMessages.USER_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.USER_NO_CONTENT);
		});

		u.setName(user.getName());
		u.setBirthdate(user.getBirthdate());
		u.setPassword(encoder.encode(user.getPassword()));
		u.setCountry(user.getCountry());
		u.setMail(user.getMail());
		u.setLastname(user.getLastname());
		u.setExperience(user.getExperience());
		u.setOccupation(user.getOccupation());

		for (RolEntity r : u.getRoles())
			r.getUsers().remove(u);

		RolEntity r = rolRepository.findByName(user.getRol().getName().toString()).orElseThrow(() -> {
			logger.warn(DataErrorMessages.ROLE_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.ROLE_NO_CONTENT);
		});

		r.getUsers().add(u);

		userRepository.save(u);

		return user;

	}

	// deleteUser: Elimina un usuario de la BBDD
	@Override
	@Transactional
	public void deleteUser(Long id) {

		UserEntity u = userRepository.findById(id).orElseThrow(() -> {
			logger.warn(DataErrorMessages.USER_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.USER_NO_CONTENT);
		});

		for (RolEntity r : u.getRoles())
			r.getUsers().remove(u);

		userRepository.delete(u);

	}

	// getUsers: Muestra los datos de todos los usuarios registrados en la BBDD
	@Override
	@Transactional(readOnly = true)
	public List<UserDto> getUsers() {

		List<UserEntity> userEntities = userRepository.findAll();
		List<UserDto> userDTOs = new ArrayList<>();

		for (UserEntity u : userEntities)
			userDTOs.add(etd.getUser(u));
		return userDTOs;

	}

	// getUser: Muestra los datos de un único usuario
	@Override
	public UserDto getUser(Long id) {

		return etd.getUser(userRepository.findById(id).orElseThrow(() -> {
			logger.warn(DataErrorMessages.USER_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.USER_NO_CONTENT);
		}));

	}

	@Override
	public UserDto getUserByUserName(String userName) {
		return etd.getUser(userRepository.findByName(userName).orElseThrow(() -> {
			logger.warn(DataErrorMessages.USER_NO_CONTENT);
			throw new UserNoContentException(DataErrorMessages.USER_NO_CONTENT);
		}));
	}

	//Carga inicial de usuarios
	@Override
	public void loadUsers(List<UserDto> users) {
		for (UserDto userDto : users) {
			userRepository.save(dte.getUser(userDto));
		}
	}


}
