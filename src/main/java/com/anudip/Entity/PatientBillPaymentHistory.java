package com.anudip.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="PatientBillPaymentHistory_Info")
public class PatientBillPaymentHistory {
	@Id
	private Integer pbhid;
	
	@Column(length=25, nullable = false)
	private Boolean patientPaid;
	
	@Column(length=25, nullable = false, unique = true)
	private Boolean insurancePaid;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "patient payable amuount cannot be null")
	private long Amount;

	@Column(length=20, nullable = false)
	@NotNull(message = "patient date of birth cannot be blank")
	private String dateofpayment;
	

	public Integer getPbhid() {
		return pbhid;
	}

	public void setPbhid(Integer pbhid) {
		this.pbhid = pbhid;
	}

	public Boolean getPatientPaid() {
		return patientPaid;
	}

	public void setPatientPaid(Boolean patientPaid) {
		this.patientPaid = patientPaid;
	}

	public Boolean getInsurancePaid() {
		return insurancePaid;
	}

	public void setInsurancePaid(Boolean insurancePaid) {
		this.insurancePaid = insurancePaid;
	}

	public long getAmount() {
		return Amount;
	}

	public void setAmount(long amount) {
		Amount = amount;
	}

	public String getDateofpayment() {
		return dateofpayment;
	}

	public void setDateofpayment(String dateofpayment) {
		this.dateofpayment = dateofpayment;
	}

	public PatientBillPaymentHistory(Integer pbhid, Boolean patientPaid, Boolean insurancePaid,
			@NotNull(message = "patient payable amuount cannot be null") long amount,
			@NotNull(message = "patient date of birth cannot be blank") String dateofpayment) {
		super();
		this.pbhid = pbhid;
		this.patientPaid = patientPaid;
		this.insurancePaid = insurancePaid;
		Amount = amount;
		this.dateofpayment = dateofpayment;
	}

	public PatientBillPaymentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatientBillPaymentHistory [" + (pbhid != null ? "pbhid=" + pbhid + ", " : "")
				+ (patientPaid != null ? "patientPaid=" + patientPaid + ", " : "")
				+ (insurancePaid != null ? "insurancePaid=" + insurancePaid + ", " : "") + "Amount=" + Amount + ", "
				+ (dateofpayment != null ? "dateofpayment=" + dateofpayment : "") + "]";
	}
	

	
}
