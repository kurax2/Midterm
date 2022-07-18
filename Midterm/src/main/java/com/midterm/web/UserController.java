package com.midterm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.midterm.model.MySecuredUsers;
import com.midterm.repo.AppUsersRepository;
import com.midterm.service.AppUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	AppUserService appUserService;
	
	@Autowired
	AppUsersRepository userRepo;
	
	@GetMapping("/{username}/viewprofile")
	public MySecuredUsers getUserByUsername(@PathVariable String username)
	{
		MySecuredUsers a=userRepo.getUsersByUsername(username);
		return a;
	}
	
	@PutMapping("/{username}/updatepincode/{pincode}")
	public MySecuredUsers setPinByUsername(@PathVariable String username,@PathVariable long pincode)
	{
		MySecuredUsers a=userRepo.getUsersByUsername(username);
		a.setPincode(pincode);
		userRepo.save(a);
		return a;
	}
	

}
