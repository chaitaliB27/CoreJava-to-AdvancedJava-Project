package com.repms.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class AgentDTO {
    private int ait;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = " Agent Name cannot be blank")
	private String afname;
	
	@Column(length=25)
	private String alname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Agent phone cannot be null")
	private long aphone;
	
	@Column(length=100, nullable = false, unique = true)
	@NotBlank(message = "Agent Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String aemail;

	public int getAit() {
		return ait;
	}

	public void setAit(int ait) {
		this.ait = ait;
	}

	public String getAfname() {
		return afname;
	}

	public void setAfname(String afname) {
		this.afname = afname;
	}

	public String getAlname() {
		return alname;
	}

	public void setAlname(String alname) {
		this.alname = alname;
	}

	public long getAphone() {
		return aphone;
	}

	public void setAphone(long aphone) {
		this.aphone = aphone;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	

	public AgentDTO(int ait, @NotBlank(message = " Agent Name cannot be blank") String afname, String alname,
			@NotNull(message = "Agent phone cannot be null") long aphone,
			@NotBlank(message = "Agent Email cannot be blank") @Email(message = "Email is incorrect") String aemail) {
		super();
		this.ait = ait;
		this.afname = afname;
		this.alname = alname;
		this.aphone = aphone;
		this.aemail = aemail;
	}

	public AgentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AgentDTO [ait=" + ait + ", afname=" + afname + ", alname=" + alname + ", aphone=" + aphone + ", aemail="
				+ aemail + "]";
	}
	
}
