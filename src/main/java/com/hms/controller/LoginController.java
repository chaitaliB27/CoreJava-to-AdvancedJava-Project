package com.hms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.Entity.Login;
import com.hms.Service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
@RestController
public class LoginController {
	@Autowired
	LoginService loginservice;
	
	@PostMapping("/login")
	public String Validate(@RequestBody Login user) throws ServletException
	{
		String jwtToken="";
		
		if(user.getUserName()== null || user.getPassword()==null)
		{
			throw new ServletException("please fill the username and the passsword");
		}
		
		String userName=user.getUserName();
		String password=user.getPassword();
		
		user=loginservice.loginUser(userName, password);
		
		jwtToken=Jwts.builder().setSubject(userName)
				.claim("role", "user").setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return jwtToken;
	}
}
