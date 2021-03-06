package com.sinexperiencia.sinexperiencia.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinexperiencia.sinexperiencia.entities.UserEntity;
import com.sinexperiencia.sinexperiencia.exceptions.messages.DataErrorMessages;
import com.sinexperiencia.sinexperiencia.repositories.UserRepository;
import com.sinexperiencia.sinexperiencia.services.LoginService;



@Service
@Transactional
public class LoginServiceImpl implements LoginService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity u = repo.findByName(username).orElseThrow(() -> {
			logger.warn(DataErrorMessages.USER_NO_CONTENT);
			throw new UsernameNotFoundException(DataErrorMessages.USER_NO_CONTENT);
		});;
		
		List<GrantedAuthority> roles = u.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
		
		return new User(u.getName(), u.getPassword(), true, true, true, true, roles);
		
	}

	@Override
	public Optional<UserEntity> findByUsername(String username) {
		return repo.findByName(username);
	}

}