package com.repms.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Property_info")
public class Property {
	@Id
	private int pit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Property Address cannot be blank")
	private String padd;
	
	@Column(length=25)
	private String pdescription;
	
	@Column(length=25, nullable = false, unique = true)
	private int pnofroom;
	
	@Column(length=25, nullable = false, unique = true)
	private int pnofbedroom;
	
	@Column(length=20, nullable = false)
	private String pnofbathroom;

	public int getPit() {
		return pit;
	}

	public void setPit(int pit) {
		this.pit = pit;
	}

	public String getPadd() {
		return padd;
	}

	public void setPadd(String padd) {
		this.padd = padd;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public int getPnofroom() {
		return pnofroom;
	}

	public void setPnofroom(int pnofroom) {
		this.pnofroom = pnofroom;
	}

	public int getPnofbedroom() {
		return pnofbedroom;
	}

	public void setPnofbedroom(int pnofbedroom) {
		this.pnofbedroom = pnofbedroom;
	}

	public String getPnofbathroom() {
		return pnofbathroom;
	}

	public void setPnofbathroom(String pnofbathroom) {
		this.pnofbathroom = pnofbathroom;
	}

	@Override
	public String toString() {
		return "Property [pit=" + pit + ", padd=" + padd + ", pdescription=" + pdescription + ", pnofroom=" + pnofroom
				+ ", pnofbedroom=" + pnofbedroom + ", pnofbathroom=" + pnofbathroom + "]";
	}

	

	public Property(int pit, @NotBlank(message = "Property Address cannot be blank") String padd, String pdescription,
			int pnofroom, int pnofbedroom, String pnofbathroom) {
		super();
		this.pit = pit;
		this.padd = padd;
		this.pdescription = pdescription;
		this.pnofroom = pnofroom;
		this.pnofbedroom = pnofbedroom;
		this.pnofbathroom = pnofbathroom;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
