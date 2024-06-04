package com.hms.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="patient_info")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Patient Name cannot be blank")
	private String pfname;
	
	@Column(length=25)
	private String plname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Patient phone cannot be null")
	private long pphone;
	
	@Column(length=25, nullable = false, unique = true)
	@NotBlank(message = "Patient Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String pemail;
	
	@Column(length=20, nullable = false)
	private int age;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "patient Address cannot be blank")
	private String saddr;
	
	@Column(length=20, nullable = false)
	@NotNull(message = "patient date of birth cannot be blank")
	private String dateofbirth;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="epersonID", referencedColumnName = "epid")
	@JsonBackReference
	private EmergencyContactPerson emergencyContactPerson;
	
	@OneToOne(mappedBy = "patient",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private HealthInsurance HealthInsurance;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPfname() {
		return pfname;
	}

	public void setPfname(String pfname) {
		this.pfname = pfname;
	}

	public String getPlname() {
		return plname;
	}

	public void setPlname(String plname) {
		this.plname = plname;
	}

	public long getPphone() {
		return pphone;
	}

	public void setPphone(long pphone) {
		this.pphone = pphone;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public EmergencyContactPerson getEmergencyContactPerson() {
		return emergencyContactPerson;
	}

	public void setEmergencyContactPerson(EmergencyContactPerson emergencyContactPerson) {
		this.emergencyContactPerson = emergencyContactPerson;
	}

	public HealthInsurance getHealthInsurance() {
		return HealthInsurance;
	}

	public void setHealthInsurance(HealthInsurance healthInsurance) {
		HealthInsurance = healthInsurance;
	}

	
	public Patient(int pid, @NotBlank(message = "Patient Name cannot be blank") String pfname, String plname,
			@NotNull(message = "Patient phone cannot be null") long pphone,
			@NotBlank(message = "Patient Email cannot be blank") @Email(message = "Email is incorrect") String pemail,
			int age, @NotBlank(message = "patient Address cannot be blank") String saddr,
			@NotNull(message = "patient date of birth cannot be blank") String dateofbirth,
			EmergencyContactPerson emergencyContactPerson, com.hms.Entity.HealthInsurance healthInsurance) {
		super();
		this.pid = pid;
		this.pfname = pfname;
		this.plname = plname;
		this.pphone = pphone;
		this.pemail = pemail;
		this.age = age;
		this.saddr = saddr;
		this.dateofbirth = dateofbirth;
		this.emergencyContactPerson = emergencyContactPerson;
		HealthInsurance = healthInsurance;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pfname=" + pfname + ", plname=" + plname + ", pphone=" + pphone + ", pemail="
				+ pemail + ", age=" + age + ", saddr=" + saddr + ", dateofbirth=" + dateofbirth
				+ ", emergencyContactPerson=" + emergencyContactPerson + ", HealthInsurance=" + HealthInsurance + "]";
	}

	
}
