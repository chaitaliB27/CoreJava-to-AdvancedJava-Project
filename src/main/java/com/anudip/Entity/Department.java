package com.anudip.Entity;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Department_Info")
public class Department {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	
	@Column(length=20, nullable = true)
	@NotBlank(message = "Department Name cannot be blank")
	private String deptName;
	
	@Column(length=20)
	private String deptHODName;
	
	@Column(length=40, nullable = true)
	@NotNull(message = "kindly mention no of employess")
	private int onOfEmpl;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Department phone cannot be null")
	private long dphone;
	
	@Column(length=25)
	private String labNo;
	
	@OneToMany(mappedBy = "department", 
		     fetch = FetchType.EAGER, cascade = CascadeType.ALL)
			@JsonManagedReference
			private List<Doctor> DoctorDetails;

	@OneToMany(mappedBy = "departmentN", 
		     fetch = FetchType.EAGER, cascade = CascadeType.ALL)
			@JsonManagedReference
			private List<Nurse> NurseDetails;
	
	@OneToMany(mappedBy = "departmentD", 
		     fetch = FetchType.EAGER, cascade = CascadeType.ALL)
			@JsonManagedReference
			private List<HospitalDiagnosisList> HospitalDiagnosisListDetails;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHODName() {
		return deptHODName;
	}

	public void setDeptHODName(String deptHODName) {
		this.deptHODName = deptHODName;
	}

	public int getOnOfEmpl() {
		return onOfEmpl;
	}

	public void setOnOfEmpl(int onOfEmpl) {
		this.onOfEmpl = onOfEmpl;
	}

	public long getDphone() {
		return dphone;
	}

	public void setDphone(long dphone) {
		this.dphone = dphone;
	}

	public String getLabNo() {
		return labNo;
	}

	public void setLabNo(String labNo) {
		this.labNo = labNo;
	}

	public List<Doctor> getDoctorDetails() {
		return DoctorDetails;
	}

	public void setDoctorDetails(List<Doctor> doctorDetails) {
		DoctorDetails = doctorDetails;
	}

	public List<Nurse> getNurseDetails() {
		return NurseDetails;
	}

	public void setNurseDetails(List<Nurse> nurseDetails) {
		NurseDetails = nurseDetails;
	}

	public List<HospitalDiagnosisList> getHospitalDiagnosisListDetails() {
		return HospitalDiagnosisListDetails;
	}

	public void setHospitalDiagnosisListDetails(List<HospitalDiagnosisList> hospitalDiagnosisListDetails) {
		HospitalDiagnosisListDetails = hospitalDiagnosisListDetails;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Department [did=" + did + ", deptName=" + deptName + ", deptHODName=" + deptHODName + ", onOfEmpl="
				+ onOfEmpl + ", dphone=" + dphone + ", labNo=" + labNo + ", DoctorDetails="
				+ (DoctorDetails != null ? DoctorDetails.subList(0, Math.min(DoctorDetails.size(), maxLen)) : null)
				+ ", NurseDetails="
				+ (NurseDetails != null ? NurseDetails.subList(0, Math.min(NurseDetails.size(), maxLen)) : null)
				+ ", HospitalDiagnosisListDetails="
				+ (HospitalDiagnosisListDetails != null
						? HospitalDiagnosisListDetails.subList(0, Math.min(HospitalDiagnosisListDetails.size(), maxLen))
						: null)
				+ "]";
	}

	

	public Department(int did, @NotBlank(message = "Department Name cannot be blank") String deptName,
			String deptHODName, @NotNull(message = "kindly mention no of employess") int onOfEmpl,
			@NotNull(message = "Department phone cannot be null") long dphone, String labNo, List<Doctor> doctorDetails,
			List<Nurse> nurseDetails, List<HospitalDiagnosisList> hospitalDiagnosisListDetails) {
		super();
		this.did = did;
		this.deptName = deptName;
		this.deptHODName = deptHODName;
		this.onOfEmpl = onOfEmpl;
		this.dphone = dphone;
		this.labNo = labNo;
		DoctorDetails = doctorDetails;
		NurseDetails = nurseDetails;
		HospitalDiagnosisListDetails = hospitalDiagnosisListDetails;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
