package com.midterm.web;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midterm.service.AppUserService;
import com.midterm.dto.AppUserRequestDTO;
import com.midterm.dto.JWTResponseDTO;
import com.midterm.util.JWTUtil;
import com.midterm.model.MySecuredUsers;
import com.midterm.service.AppUserServiceImpl;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JWTResponseDTO> doLogin(@RequestBody AppUserRequestDTO userEntry)throws Exception
	{
		System.out.println("----->> inside public/login "+userEntry);
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntry.getUsername(), userEntry.getPassword()));
			System.out.println();
			
		} catch (Exception e) {
			throw new Exception("Bad credentials ");
		}

		UserDetails userDetails =  appUserService.loadUserByUsername(userEntry.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		boolean isValid = token!=null?true:false;
		
		JWTResponseDTO jwtResponseDTO = new JWTResponseDTO(token, userEntry.getUsername(), isValid);
		
		return new ResponseEntity<JWTResponseDTO>(jwtResponseDTO, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public MySecuredUsers adduser(@RequestBody MySecuredUsers a) {
		return appUserService.saveUsers(a);
		
	}
	
	
}
