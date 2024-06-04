package com.hms.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="HDList_info")
public class HospitalDiagnosisList {
	@Id
	private int hdid;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String dName;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String lab_Add;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String lab_phoneOrMobile;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String lab_email;
	
	@Column(length=25, nullable = false)
	@NotNull(message = "Student phone cannot be null")
	private long DiagnosisTest_price;

	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="DepartmentId", referencedColumnName = "did")
	@JsonBackReference
	private Department departmentD;

	public int getHdid() {
		return hdid;
	}

	public void setHdid(int hdid) {
		this.hdid = hdid;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLab_Add() {
		return lab_Add;
	}

	public void setLab_Add(String lab_Add) {
		this.lab_Add = lab_Add;
	}

	public String getLab_phoneOrMobile() {
		return lab_phoneOrMobile;
	}

	public void setLab_phoneOrMobile(String lab_phoneOrMobile) {
		this.lab_phoneOrMobile = lab_phoneOrMobile;
	}

	public String getLab_email() {
		return lab_email;
	}

	public void setLab_email(String lab_email) {
		this.lab_email = lab_email;
	}

	public long getDiagnosisTest_price() {
		return DiagnosisTest_price;
	}

	public void setDiagnosisTest_price(long diagnosisTest_price) {
		DiagnosisTest_price = diagnosisTest_price;
	}

	public Department getDepartmentD() {
		return departmentD;
	}

	public void setDepartmentD(Department departmentD) {
		this.departmentD = departmentD;
	}

	@Override
	public String toString() {
		return "HospitalDiagnosisList [hdid=" + hdid + ", dName=" + dName + ", lab_Add=" + lab_Add
				+ ", lab_phoneOrMobile=" + lab_phoneOrMobile + ", lab_email=" + lab_email + ", DiagnosisTest_price="
				+ DiagnosisTest_price + ", departmentD=" + departmentD + "]";
	}

	public HospitalDiagnosisList(int hdid, @NotBlank(message = "Student Name cannot be blank") String dName,
			@NotBlank(message = "Student Name cannot be blank") String lab_Add,
			@NotBlank(message = "Student Name cannot be blank") String lab_phoneOrMobile,
			@NotBlank(message = "Student Name cannot be blank") String lab_email,
			@NotNull(message = "Student phone cannot be null") long diagnosisTest_price, Department departmentD) {
		super();
		this.hdid = hdid;
		this.dName = dName;
		this.lab_Add = lab_Add;
		this.lab_phoneOrMobile = lab_phoneOrMobile;
		this.lab_email = lab_email;
		DiagnosisTest_price = diagnosisTest_price;
		this.departmentD = departmentD;
	}

	public HospitalDiagnosisList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
