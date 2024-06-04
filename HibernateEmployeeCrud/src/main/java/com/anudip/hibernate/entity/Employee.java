package com.anudip.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@Column(name="First_Name", length = 20)
	private String empName;
	
	@Column(name="Last_Name", length = 20)
	private String surname;
	
	@Column(name="Phone_Number", length = 20)
	private long phone;
	
	@Column(name="Address", length = 20)
	private String address;
	
	@Column(name="Designation", length = 20)
	private String designation;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String surname, long phone, String address, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.designation = designation;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", surname=" + surname + ", phone=" + phone
				+ ", address=" + address + ", designation=" + designation + "]";
	}

}
