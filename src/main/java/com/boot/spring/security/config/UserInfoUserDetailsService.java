package com.boot.spring.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.boot.spring.security.entity.UserInfo;
import com.boot.spring.security.repository.UserInforRepository;
@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInforRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo=repository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("user not found" +username));
		
	}

}
