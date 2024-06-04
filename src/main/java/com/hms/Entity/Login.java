package com.hms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Login {
	@Id
	private int uid;
	@Column(length = 8, nullable = false)
	private String userName;
	@Column(length = 10, nullable = false)
	private String password;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [uid=" + uid + ", userName=" + userName + ", password=" + password + "]";
	}
	public Login(int uid, String userName, String password) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.password = password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
