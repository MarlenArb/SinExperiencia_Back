package com.sinexperiencia.sinexperiencia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinexperiencia.sinexperiencia.dtos.UserDto;


@Service
public interface UserService {

	public UserDto getUser(Long id);
	public UserDto getUserByUserName(String userName);
	public void addUser(UserDto user);
	public void deleteUser(Long id);
	public List<UserDto> getUsers();
	public UserDto modifyUser(Long id, UserDto user);
}
