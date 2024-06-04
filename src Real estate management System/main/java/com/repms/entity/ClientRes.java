package com.repms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Client_info")
public class ClientRes {
	@Id@GeneratedValue
	private int cit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Client Name cannot be blank")
	private String cfname;
	
	@Column(length=25)
	private String clname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Client phone cannot be null")
	private long cphone;
	
	@Column(length=100, nullable = false, unique = true)
	@NotBlank(message = "Client Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String cemail;
	
	@Column(length=20, nullable = false)
	private String gender;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Client Address cannot be blank")
	private String caddr;
	
	@Column(length=20, nullable = false)
	@NotBlank(message = "Client Username cannot be blank")
	private String username;
	
	@Column(length=20, nullable = false)
	@NotBlank(message = "Client Password cannot be blank")
	private String password;

	public int getCit() {
		return cit;
	}

	public void setCit(int cit) {
		this.cit = cit;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public long getCphone() {
		return cphone;
	}

	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ClientRes [cit=" + cit + ", cfname=" + cfname + ", clname=" + clname + ", cphone=" + cphone
				+ ", cemail=" + cemail + ", gender=" + gender + ", caddr=" + caddr + ", username=" + username
				+ ", password=" + password + "]";
	}

	
	public ClientRes(int cit, @NotBlank(message = "Client Name cannot be blank") String cfname, String clname,
			@NotNull(message = "Client phone cannot be null") long cphone,
			@NotBlank(message = "Client Email cannot be blank") @Email(message = "Email is incorrect") String cemail,
			String gender, @NotBlank(message = "Client Address cannot be blank") String caddr,
			@NotBlank(message = "Client Username cannot be blank") String username,
			@NotBlank(message = "Client Password cannot be blank") String password) {
		super();
		this.cit = cit;
		this.cfname = cfname;
		this.clname = clname;
		this.cphone = cphone;
		this.cemail = cemail;
		this.gender = gender;
		this.caddr = caddr;
		this.username = username;
		this.password = password;
	}

	public ClientRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
