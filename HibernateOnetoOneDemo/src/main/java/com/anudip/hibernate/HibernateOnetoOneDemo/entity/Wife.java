package com.anudip.hibernate.HibernateOnetoOneDemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Wife_details")
public class Wife {
	
	@Id
	@Column(name="Wife_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int wid;
	
	@Column(name="Wife_Name")
	private String wName;
	
	@OneToOne(mappedBy = "wife", cascade = CascadeType.ALL)
	private Husband husband;
	
	public Wife() {
		super();
	}

	public Wife(int wid, String wName, Husband husband) {
		super();
		this.wid = wid;
		this.wName = wName;
		this.husband = husband;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return "Wife [wid=" + wid + ", wName=" + wName + ", husband=" + husband + "]";
	}
}
