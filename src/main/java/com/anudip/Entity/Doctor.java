package com.anudip.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Doctors_Info")
public class Doctor {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doid;

	@Column(length=25, nullable = false)
	@NotBlank
	private String dfname;
	
	@NotBlank
	@Column(length=25)
	private String dlname;
	
	@NotNull
	@Column(length=25, nullable = false, unique = true)
	private long dphone;
	
	
	@Column(length=50, nullable = false, unique = true)
	@Email(message = "Email is incorrect")
	private String demail;
	
	@NotBlank
	@Column(length=20, nullable = false)
	private String dspecialization;
	
	@NotNull
	@Column(length=50, nullable = false)
	private Long dvisitprice;
	
	@NotNull
	@Column(length=50, nullable = false)
    private Long dfollowupprice;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="DepartmentId", referencedColumnName = "did")
	@JsonBackReference
	private Department department;

	public int getDoid() {
		return doid;
	}

	public void setDoid(int doid) {
		this.doid = doid;
	}

	public String getDfname() {
		return dfname;
	}

	public void setDfname(String dfname) {
		this.dfname = dfname;
	}

	public String getDlname() {
		return dlname;
	}

	public void setDlname(String dlname) {
		this.dlname = dlname;
	}

	public long getDphone() {
		return dphone;
	}

	public void setDphone(long dphone) {
		this.dphone = dphone;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getDspecialization() {
		return dspecialization;
	}

	public void setDspecialization(String dspecialization) {
		this.dspecialization = dspecialization;
	}

	public Long getDvisitprice() {
		return dvisitprice;
	}

	public void setDvisitprice(Long dvisitprice) {
		this.dvisitprice = dvisitprice;
	}

	public Long getDfollowupprice() {
		return dfollowupprice;
	}

	public void setDfollowupprice(Long dfollowupprice) {
		this.dfollowupprice = dfollowupprice;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Doctor(int doid, @NotBlank @NotBlank String dfname, @NotBlank String dlname, @NotNull long dphone,
			@NotBlank @Email(message = "Email is incorrect") String demail, @NotBlank String dspecialization,
			@NotNull Long dvisitprice, @NotNull Long dfollowupprice, Department department) {
		super();
		this.doid = doid;
		this.dfname = dfname;
		this.dlname = dlname;
		this.dphone = dphone;
		this.demail = demail;
		this.dspecialization = dspecialization;
		this.dvisitprice = dvisitprice;
		this.dfollowupprice = dfollowupprice;
		this.department = department;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [doid=" + doid + ", dfname=" + dfname + ", dlname=" + dlname + ", dphone=" + dphone + ", demail="
				+ demail + ", dspecialization=" + dspecialization + ", dvisitprice=" + dvisitprice + ", dfollowupprice="
				+ dfollowupprice + ", department=" + department + "]";
	}


	
	
}
