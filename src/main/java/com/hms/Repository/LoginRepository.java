package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.Login;


public interface LoginRepository extends JpaRepository<Login, Integer>{
	public Login findByUserNameAndPassword(String userName, String password);
}
