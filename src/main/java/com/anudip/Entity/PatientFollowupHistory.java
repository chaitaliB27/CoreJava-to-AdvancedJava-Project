package com.anudip.Entity;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="PatientFollowupHostory")
public class PatientFollowupHistory {
	@Id
	private int pfhid;
	
	@Column(length=25)
	private String dateoffollowup;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="followupAnddiagnosis_Table",
    joinColumns= {
    		@JoinColumn(name="followup_id",referencedColumnName = "pfhid")
    },
    inverseJoinColumns = {
    		@JoinColumn(name="Diagnosis_id",referencedColumnName = "pdhid")	
    })
	private Set<PatientDiagnosisHistory>patientDiagnosisHistorydatils;

	public int getPfhid() {
		return pfhid;
	}

	public void setPfhid(int pfhid) {
		this.pfhid = pfhid;
	}

	public String getDateoffollowup() {
		return dateoffollowup;
	}

	public void setDateoffollowup(String dateoffollowup) {
		this.dateoffollowup = dateoffollowup;
	}

	public Set<PatientDiagnosisHistory> getPatientDiagnosisHistorydatils() {
		return patientDiagnosisHistorydatils;
	}

	public void setPatientDiagnosisHistorydatils(Set<PatientDiagnosisHistory> patientDiagnosisHistorydatils) {
		this.patientDiagnosisHistorydatils = patientDiagnosisHistorydatils;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "PatientFollowupHistory [pfhid=" + pfhid + ", dateoffollowup=" + dateoffollowup
				+ ", patientDiagnosisHistorydatils="
				+ (patientDiagnosisHistorydatils != null ? toString(patientDiagnosisHistorydatils, maxLen) : null)
				+ "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	public PatientFollowupHistory(int pfhid, String dateoffollowup,
			Set<PatientDiagnosisHistory> patientDiagnosisHistorydatils) {
		super();
		this.pfhid = pfhid;
		this.dateoffollowup = dateoffollowup;
		this.patientDiagnosisHistorydatils = patientDiagnosisHistorydatils;
	}

	public PatientFollowupHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
