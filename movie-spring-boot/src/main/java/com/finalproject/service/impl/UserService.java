package com.finalproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.finalproject.authentication.MyUserDetails;
import com.finalproject.entity.UserEntity;
import com.finalproject.repository.UserRepository;

public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("Could not find user"); 
		}
		
		
		return new MyUserDetails(userEntity);
	}

}
