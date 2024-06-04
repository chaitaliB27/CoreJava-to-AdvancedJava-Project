package com.hms.Entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="patientBill_info")
public class PatientBill {
	@Id
	private int pbid;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "patient payable amuount cannot be null")
	private long ppayableAmount;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "health insurance comapany amount cannot be null")
	private long hicpayableAmount;

	public int getPbid() {
		return pbid;
	}

	public void setPbid(int pbid) {
		this.pbid = pbid;
	}

	public long getPpayableAmount() {
		return ppayableAmount;
	}

	public void setPpayableAmount(long ppayableAmount) {
		this.ppayableAmount = ppayableAmount;
	}

	public long getHicpayableAmount() {
		return hicpayableAmount;
	}

	public void setHicpayableAmount(long hicpayableAmount) {
		this.hicpayableAmount = hicpayableAmount;
	}

	public PatientBill(int pbid, @NotNull(message = "patient payable amuount cannot be null") long ppayableAmount,
			@NotNull(message = "health insurance comapany amount cannot be null") long hicpayableAmount) {
		super();
		this.pbid = pbid;
		this.ppayableAmount = ppayableAmount;
		this.hicpayableAmount = hicpayableAmount;
	}

	public PatientBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatientBill [pbid=" + pbid + ", ppayableAmount=" + ppayableAmount + ", hicpayableAmount="
				+ hicpayableAmount + "]";
	}
	
	/*@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="Patient_Id", referencedColumnName = "pid")
	@JsonBackReference
	private Patient patientB;
*/
	
}
