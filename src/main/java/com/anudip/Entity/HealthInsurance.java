package com.anudip.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Hcompany_Info")
public class HealthInsurance {
	@Id
	private int hcid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "company Name cannot be blank")
	private String cName;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Student phone cannot be null")
	private long cphone;
	
	@NotBlank
	@Column(length=50, nullable = false, unique = true)
	@Email(message = "Email is incorrect")
	private String cemail;
	@Column(length=25)
	private String cadd;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="PatientID", referencedColumnName = "pid")
	@JsonBackReference
	private Patient patient;

	public int getHcid() {
		return hcid;
	}

	public void setHcid(int hcid) {
		this.hcid = hcid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
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

	public String getCadd() {
		return cadd;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public HealthInsurance(int hcid, @NotBlank(message = "company Name cannot be blank") String cName,
			@NotNull(message = "Student phone cannot be null") long cphone,
			@NotBlank @Email(message = "Email is incorrect") String cemail, String cadd, Patient patient) {
		super();
		this.hcid = hcid;
		this.cName = cName;
		this.cphone = cphone;
		this.cemail = cemail;
		this.cadd = cadd;
		this.patient = patient;
	}

	public HealthInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HealthInsurance [hcid=" + hcid + ", cName=" + cName + ", cphone=" + cphone + ", cemail=" + cemail
				+ ", cadd=" + cadd + ", patient=" + patient + "]";
	}
	
	
	

	
}
