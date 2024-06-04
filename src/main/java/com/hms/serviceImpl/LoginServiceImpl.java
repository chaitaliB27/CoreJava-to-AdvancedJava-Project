package com.hms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.Entity.Login;
import com.hms.Repository.LoginRepository;
import com.hms.Service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository lrepo;
	@Override
	public Login loginUser(String userName, String password) {
		
		Login login=lrepo.findByUserNameAndPassword(userName, password);
		return login;
	}
}
