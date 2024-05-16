package com.anudip.Entity;
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
@Table(name="PatientAdmissionHistory_info")
public class PatientAdmissionHistory {
	@Id
	private int pahid;
	
	@Column(length=25, nullable = false)
	private String ward_No;
	
	@Column(length=25, nullable = false)
	private int bed_No;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "PatientAdmission Date cannot be blank")
	private String admission_date;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Patient  Discharge cannot be blank")
	private String discharge_date;
	
	@Column(length=25, nullable = false)
	@NotNull(message = "tatal Bill cannot be blank")
	private int tatalCost;
	
	

	public int getPahid() {
		return pahid;
	}

	public void setPahid(int pahid) {
		this.pahid = pahid;
	}

	public String getWard_No() {
		return ward_No;
	}

	public void setWard_No(String ward_No) {
		this.ward_No = ward_No;
	}

	public int getBed_No() {
		return bed_No;
	}

	public void setBed_No(int bed_No) {
		this.bed_No = bed_No;
	}

	public String getAdmission_date() {
		return admission_date;
	}

	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}

	public String getDischarge_date() {
		return discharge_date;
	}

	public void setDischarge_date(String discharge_date) {
		this.discharge_date = discharge_date;
	}

	public int getTatalCost() {
		return tatalCost;
	}

	public void setTatalCost(int tatalCost) {
		this.tatalCost = tatalCost;
	}

	public PatientAdmissionHistory(int pahid, String ward_No, int bed_No,
			@NotBlank(message = "PatientAdmission Date cannot be blank") String admission_date,
			@NotBlank(message = "Patient  Discharge cannot be blank") String discharge_date,
			@NotNull(message = "tatal Bill cannot be blank") int tatalCost) {
		super();
		this.pahid = pahid;
		this.ward_No = ward_No;
		this.bed_No = bed_No;
		this.admission_date = admission_date;
		this.discharge_date = discharge_date;
		this.tatalCost = tatalCost;
	}

	public PatientAdmissionHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatientAdmissionHistory [pahid=" + pahid + ", ward_No=" + ward_No + ", bed_No=" + bed_No
				+ ", admission_date=" + admission_date + ", discharge_date=" + discharge_date + ", tatalCost="
				+ tatalCost + "]";
	}
}
