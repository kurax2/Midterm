package com.midterm.service;

import org.springframework.stereotype.Service;

import com.midterm.model.MySecuredUsers;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public interface AppUserService extends UserDetailsService{
	public MySecuredUsers saveUsers(MySecuredUsers appUsers);
}
