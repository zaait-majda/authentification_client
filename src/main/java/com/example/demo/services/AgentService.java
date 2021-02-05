package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.models.*;

@Service
public class AgentService implements UserDetailsService {
	
	@Autowired
	private AgentRepository agentRepository ;

	@Override
	public UserDetails loadUserByUsername(String tel) throws UsernameNotFoundException {
		UserModel foundedUser=  agentRepository.findBytel(tel);
		if (foundedUser== null ) return null;
		String tell = foundedUser.getTel();
		String password=foundedUser.getPassword();
		return new User (tell,password,new ArrayList<>());

	}
	
	

}
