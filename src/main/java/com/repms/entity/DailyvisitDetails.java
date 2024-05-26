package com.repms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="DailyvisitDetails_info")
public class DailyvisitDetails {
	@Id
	private int dvit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Client Name cannot be blank")
	private String cfname;
	
	@Column(length=25)
	private String clname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "client Visited Date cannot be blank")
	private String visitDate;
	
	@Column(length=100)
	private String clientWish;

	public int getDvit() {
		return dvit;
	}

	public void setDvit(int dvit) {
		this.dvit = dvit;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getClientWish() {
		return clientWish;
	}

	public void setClientWish(String clientWish) {
		this.clientWish = clientWish;
	}

	public DailyvisitDetails(int dvit, @NotBlank(message = "Client Name cannot be blank") String cfname, String clname,
			@NotBlank(message = "client Visited Date cannot be blank") String visitDate, String clientWish) {
		super();
		this.dvit = dvit;
		this.cfname = cfname;
		this.clname = clname;
		this.visitDate = visitDate;
		this.clientWish = clientWish;
	}

	public DailyvisitDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DailyvisitDetails [dvit=" + dvit + ", cfname=" + cfname + ", clname=" + clname + ", visitDate="
				+ visitDate + ", clientWish=" + clientWish + "]";
	}

	
}
