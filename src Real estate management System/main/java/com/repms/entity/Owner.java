package com.repms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Owner_info")
public class Owner {
	@Id
	private int oit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Owner Name cannot be blank")
	private String ofname;
	
	@Column(length=25)
	private String olname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Owner phone cannot be null")
	private long ophone;
	
	@Column(length=25, nullable = false, unique = true)
	@NotBlank(message = "Owner Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String oemail;

	public int getOit() {
		return oit;
	}

	public void setOit(int oit) {
		this.oit = oit;
	}

	public String getOfname() {
		return ofname;
	}

	public void setOfname(String ofname) {
		this.ofname = ofname;
	}

	public String getOlname() {
		return olname;
	}

	public void setOlname(String olname) {
		this.olname = olname;
	}

	public long getOphone() {
		return ophone;
	}

	public void setOphone(long ophone) {
		this.ophone = ophone;
	}

	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	@Override
	public String toString() {
		return "Owner [oit=" + oit + ", ofname=" + ofname + ", olname=" + olname + ", ophone=" + ophone + ", oemail="
				+ oemail + "]";
	}

	

	public Owner(int oit, @NotBlank(message = "Owner Name cannot be blank") String ofname, String olname,
			@NotNull(message = "Owner phone cannot be null") long ophone,
			@NotBlank(message = "Owner Email cannot be blank") @Email(message = "Email is incorrect") String oemail) {
		super();
		this.oit = oit;
		this.ofname = ofname;
		this.olname = olname;
		this.ophone = ophone;
		this.oemail = oemail;
	}

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
