package com.hms.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Econtactperson_info")
public class EmergencyContactPerson {
	@Id
	private int epid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "EmergencyContactPerson Name cannot be blank")
	private String epfname;
	
	@Column(length=25)
	private String eplname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "EmergencyContactPerson phone cannot be null")
	private long epphone;
	
	@OneToOne(mappedBy = "emergencyContactPerson",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Patient patient;

	public int getEpid() {
		return epid;
	}

	public void setEpid(int epid) {
		this.epid = epid;
	}

	public String getEpfname() {
		return epfname;
	}

	public void setEpfname(String epfname) {
		this.epfname = epfname;
	}

	public String getEplname() {
		return eplname;
	}

	public void setEplname(String eplname) {
		this.eplname = eplname;
	}

	public long getEpphone() {
		return epphone;
	}

	public void setEpphone(long epphone) {
		this.epphone = epphone;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	

	public EmergencyContactPerson(int epid,
			@NotBlank(message = "EmergencyContactPerson Name cannot be blank") String epfname, String eplname,
			@NotNull(message = "EmergencyContactPerson phone cannot be null") long epphone, Patient patient) {
		super();
		this.epid = epid;
		this.epfname = epfname;
		this.eplname = eplname;
		this.epphone = epphone;
		this.patient = patient;
	}

	public EmergencyContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmergencyContactPerson [epid=" + epid + ", epfname=" + epfname + ", eplname=" + eplname + ", epphone="
				+ epphone + ", patient=" + patient + "]";
	}

	
}
