package com.midterm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midterm.model.MySecuredUsers;
import com.midterm.repo.AppUsersRepository;
import com.midterm.service.AppUserService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AppUserService appUserService;
	
	@Autowired
	AppUsersRepository userRepo;
	
	
	@GetMapping("/users")
	public List<MySecuredUsers> getAllUsers()
	{
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{pincode}")
	public MySecuredUsers getUserByUsername(@PathVariable long pincode)
	{
		return userRepo.getByPin(pincode);
	}

}
