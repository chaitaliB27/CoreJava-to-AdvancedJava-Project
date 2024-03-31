package com.db.dao;

public interface LoginDao2 {
	
	public boolean customerLogin(String email, String password);
	public boolean adminLogin(String email, String password);
}
