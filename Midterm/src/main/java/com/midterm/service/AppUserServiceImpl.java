package com.midterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.midterm.model.MySecuredUsers;
import com.midterm.model.MyUserDetails;
import com.midterm.repo.AppUsersRepository;


@Service
public class AppUserServiceImpl implements AppUserService{

	@Autowired
	private AppUsersRepository userRepo;

	@Override  // from UserDetailsService
	public UserDetails loadUserByUsername(String username) throws 
	      UsernameNotFoundException {
		
		MySecuredUsers user =  userRepo.getUsersByUsername(username);
		System.out.println(" ");
		System.out.println("--------Inside App User Service IMP ---------- ");
		System.out.println(" Arg :- "+username);
		System.out.println(" From Database "+user);
		
		return new MyUserDetails(user);
		

	}
	
	@Override
	public MySecuredUsers saveUsers(MySecuredUsers appUsers)
	{
		
			return userRepo.save(appUsers);
		
	}
}


