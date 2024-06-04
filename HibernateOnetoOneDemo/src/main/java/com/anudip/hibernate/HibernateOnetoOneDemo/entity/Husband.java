package com.anudip.hibernate.HibernateOnetoOneDemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Husband_details")
public class Husband {
	
	@Id
	@Column(name="husband_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hid;
	
	@Column(name="Husband_name")
	private String hName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wife_id", referencedColumnName = "Wife_Id")
	private Wife wife;
	
	public Husband() {
		super();
	}

	public Husband(int hid, String hName, Wife wife) {
		super();
		this.hid = hid;
		this.hName = hName;
		this.wife = wife;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "Husband [hid=" + hid + ", hName=" + hName + "]";
	}
}
