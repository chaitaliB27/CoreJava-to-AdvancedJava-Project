package com.anudip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.Entity.Login;
import com.anudip.Repository.LoginRepository;
import com.anudip.Service.LoginService;


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
