package com.anudip.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="patientHistory_info")
public class PatientHistory {
	@Id
	private int phid;
	
	@Column(length=20, nullable = false)
	@NotNull(message = "patient date of birth cannot be blank")
	private String dateoftreatement;

	public int getPhid() {
		return phid;
	}

	public void setPhid(int phid) {
		this.phid = phid;
	}

	public String getDateoftreatement() {
		return dateoftreatement;
	}

	public void setDateoftreatement(String dateoftreatement) {
		this.dateoftreatement = dateoftreatement;
	}

	@Override
	public String toString() {
		return "PatientHistory [phid=" + phid + ", dateoftreatement=" + dateoftreatement + "]";
	}

	public PatientHistory(int phid,
			@NotNull(message = "patient date of birth cannot be blank") String dateoftreatement) {
		super();
		this.phid = phid;
		this.dateoftreatement = dateoftreatement;
	}

	public PatientHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
