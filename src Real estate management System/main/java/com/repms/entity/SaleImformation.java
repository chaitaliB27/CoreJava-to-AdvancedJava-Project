package com.repms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Sale_info")
public class SaleImformation {
	@Id
	private int sit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Date of sale cannot be blank")
	private String saleDate;
	
	@Column(length=25)
	private long priceofpropertyC;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Price of Property cannot be null")
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

	@Override
	public String toString() {
		return "SaleImformation [sit=" + sit + ", saleDate=" + saleDate + ", priceofpropertyC=" + priceofpropertyC
				+ ", priceofpropertyS=" + priceofpropertyS + ", paymentMode=" + paymentMode + "]";
	}
	
	
	public SaleImformation(int sit, @NotBlank(message = "Date of sale cannot be blank") String saleDate,
			long priceofpropertyC, @NotNull(message = "Price of Property cannot be null") long priceofpropertyS,
			String paymentMode) {
		super();
		this.sit = sit;
		this.saleDate = saleDate;
		this.priceofpropertyC = priceofpropertyC;
		this.priceofpropertyS = priceofpropertyS;
		this.paymentMode = paymentMode;
	}

	public SaleImformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
