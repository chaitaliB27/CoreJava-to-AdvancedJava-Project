package com.repms.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RentDetailsDTO {
private int rit;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Rent Name cannot be blank")
	private String rstartDate;
	
	@Column(length=25)
	private String rendDate;
	
	@Column(length=25, nullable = false, unique = true)
	private long rentPrice;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Id for Agreement cannot be null")
	private int rentalAgreementId;
	
	@Column(length=25, nullable = false, unique = true)
	private String rentalAgreementContent;

	public int getRit() {
		return rit;
	}

	public void setRit(int rit) {
		this.rit = rit;
	}

	public String getRstartDate() {
		return rstartDate;
	}

	public void setRstartDate(String rstartDate) {
		this.rstartDate = rstartDate;
	}

	public String getRendDate() {
		return rendDate;
	}

	public void setRendDate(String rendDate) {
		this.rendDate = rendDate;
	}

	public long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public int getRentalAgreementId() {
		return rentalAgreementId;
	}

	public void setRentalAgreementId(int rentalAgreementId) {
		this.rentalAgreementId = rentalAgreementId;
	}

	public String getRentalAgreementContent() {
		return rentalAgreementContent;
	}

	public void setRentalAgreementContent(String rentalAgreementContent) {
		this.rentalAgreementContent = rentalAgreementContent;
	}

	@Override
	public String toString() {
		return "RentDTO [rit=" + rit + ", rstartDate=" + rstartDate + ", rendDate=" + rendDate + ", rentPrice="
				+ rentPrice + ", rentalAgreementId=" + rentalAgreementId + ", rentalAgreementContent="
				+ rentalAgreementContent + "]";
	}

	

	public RentDetailsDTO(int rit, @NotBlank(message = "Rent Name cannot be blank") String rstartDate, String rendDate,
			long rentPrice, @NotNull(message = "Id for Agreement cannot be null") int rentalAgreementId,
			String rentalAgreementContent) {
		super();
		this.rit = rit;
		this.rstartDate = rstartDate;
		this.rendDate = rendDate;
		this.rentPrice = rentPrice;
		this.rentalAgreementId = rentalAgreementId;
		this.rentalAgreementContent = rentalAgreementContent;
	}

	public RentDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
