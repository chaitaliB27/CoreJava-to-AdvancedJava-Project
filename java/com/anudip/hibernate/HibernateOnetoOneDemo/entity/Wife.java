package com.anudip.hibernate.HibernateOnetoOneDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Hibernate- Implemetation
//Hibernate, EclipseLink and Apache OpenJPA


@Entity
@Table(name="Wife_details")
public class Wife {
	
	@Id
	@Column(name="Wife_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int wid;
	
	@Column(name="Wife_Name")
	private String wName;
	
	@OneToOne  //relation mapping
	private Husband husband; // accossiation
	
	
	public Wife() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setwName(String string) {
		this.wName = string;
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
