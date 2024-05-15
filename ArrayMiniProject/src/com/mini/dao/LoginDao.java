package com.mini.dao;

public interface LoginDao {
	
	public boolean employeeLogin(String username, String password);
	public boolean adminLogin(String username, String password);
}
