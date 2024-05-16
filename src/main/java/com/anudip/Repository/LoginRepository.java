package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.Entity.Login;


public interface LoginRepository extends JpaRepository<Login, Integer>{
	public Login findByUserNameAndPassword(String userName, String password);
}
