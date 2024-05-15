package com.mini.dao;

import com.mini.pojo.Employee;

public class LoginDaoImpl implements LoginDao {
	public Employee [] empList=null;
	
	public LoginDaoImpl(Employee [] empList) {
		
		this.empList=empList;
	}

	@Override
	public boolean employeeLogin(String username, String password) {
		
		for(Employee e:empList) {
			
			if(e!=null && e.getUsername().equals(username) && e.getPassword().equals(password)) {
				
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean adminLogin(String username, String password) {

		if(username.equals("admin") && password.equals("admin@123")) {
			
			return true;
		}
		return false;
	}

}
