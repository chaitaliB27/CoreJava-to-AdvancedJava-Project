package com.repms.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaleImformationDTO {
private int sit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String saleDate;
	
	@Column(length=25)
	private long priceofpropertyC;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Student phone cannot be null")
	private long priceofpropertyS;
	
	@Column(length=25, nullable = false, unique = true)
	
	private String paymentMode;

	public int getSit() {
		return sit;
	}

	public void setSit(int sit) {
		this.sit = sit;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public long getPriceofpropertyC() {
		return priceofpropertyC;
	}

	public void setPriceofpropertyC(long priceofpropertyC) {
		this.priceofpropertyC = priceofpropertyC;
	}

	public long getPriceofpropertyS() {
		return priceofpropertyS;
	}

	public void setPriceofpropertyS(long priceofpropertyS) {
		this.priceofpropertyS = priceofpropertyS;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public SaleImformationDTO(int sit, @NotBlank(message = "Student Name cannot be blank") String saleDate,
			long priceofpropertyC, @NotNull(message = "Student phone cannot be null") long priceofpropertyS,
			@NotBlank(message = "Student Email cannot be blank") String paymentMode) {
		super();
		this.sit = sit;
		this.saleDate = saleDate;
		this.priceofpropertyC = priceofpropertyC;
		this.priceofpropertyS = priceofpropertyS;
		this.paymentMode = paymentMode;
	}

	public SaleImformationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SaleImformationDTO [sit=" + sit + ", saleDate=" + saleDate + ", priceofpropertyC=" + priceofpropertyC
				+ ", priceofpropertyS=" + priceofpropertyS + ", paymentMode=" + paymentMode + "]";
	}

}
