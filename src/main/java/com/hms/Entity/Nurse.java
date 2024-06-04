package com.hms.Entity;
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
@Table(name="Nurse_Info")
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nid;
	@Column(length=25, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String nfname;
	
	@Column(length=25)
	private String nlname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Student phone cannot be null")
	private long nphone;
	
	@Column(length=25, nullable = false, unique = true)
	@NotBlank(message = "Student Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String nemail;
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="DepartmentId", referencedColumnName = "did")
	@JsonBackReference
	private Department departmentN;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNfname() {
		return nfname;
	}
	public void setNfname(String nfname) {
		this.nfname = nfname;
	}
	public String getNlname() {
		return nlname;
	}
	public void setNlname(String nlname) {
		this.nlname = nlname;
	}
	public long getNphone() {
		return nphone;
	}
	public void setNphone(long nphone) {
		this.nphone = nphone;
	}
	public String getNemail() {
		return nemail;
	}
	public void setNemail(String nemail) {
		this.nemail = nemail;
	}
	public Department getDepartmentN() {
		return departmentN;
	}
	public void setDepartmentN(Department departmentN) {
		this.departmentN = departmentN;
	}
	public Nurse(int nid, @NotBlank(message = "Student Name cannot be blank") String nfname, String nlname,
			@NotNull(message = "Student phone cannot be null") long nphone,
			@NotBlank(message = "Student Email cannot be blank") @Email(message = "Email is incorrect") String nemail,
			Department departmentN) {
		super();
		this.nid = nid;
		this.nfname = nfname;
		this.nlname = nlname;
		this.nphone = nphone;
		this.nemail = nemail;
		this.departmentN = departmentN;
	}
	public Nurse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Nurse [nid=" + nid + ", nfname=" + nfname + ", nlname=" + nlname + ", nphone=" + nphone + ", nemail="
				+ nemail + ", departmentN=" + departmentN + "]";
	}
	
	
}
