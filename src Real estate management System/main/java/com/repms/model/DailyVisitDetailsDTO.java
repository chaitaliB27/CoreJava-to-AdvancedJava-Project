package com.repms.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class DailyVisitDetailsDTO {
    private int dvit;

	@Column(length=25, nullable = false)
	@NotBlank(message = "Client Name cannot be blank")
	private String cfname;
	
	@Column(length=25)
	private String Clname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "DailyVisitDetail Date cannot be blank")
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
		return Clname;
	}

	public void setClname(String clname) {
		Clname = clname;
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

	@Override
	public String toString() {
		return "DailyVisitDetailsDTO [dvit=" + dvit + ", cfname=" + cfname + ", Clname=" + Clname + ", visitDate="
				+ visitDate + ", clientWish=" + clientWish + "]";
	}

	public DailyVisitDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DailyVisitDetailsDTO(int dvit, @NotBlank(message = "Client Name cannot be blank") String cfname,
			String clname, @NotBlank(message = "DailyVisitDetail Date cannot be blank") String visitDate,
			String clientWish) {
		super();
		this.dvit = dvit;
		this.cfname = cfname;
		Clname = clname;
		this.visitDate = visitDate;
		this.clientWish = clientWish;
	}

	
}
