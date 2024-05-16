package com.anudip.Entity;
import java.util.Collection;

import java.util.Iterator;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PatientDiagnosisHistory")
public class PatientDiagnosisHistory {
	@Id
	private int pdhid;
	
	@Column(length=25, nullable = false)
	private String dianame;
	
	@Column(length=25)
	private String dateofDiagnosis;
	
	@ManyToMany(mappedBy="patientDiagnosisHistorydatils",fetch=FetchType.LAZY)
    private Set<PatientFollowupHistory>patientFollowupHistoryDetail;

	public int getPdhid() {
		return pdhid;
	}

	public void setPdhid(int pdhid) {
		this.pdhid = pdhid;
	}

	public String getDianame() {
		return dianame;
	}

	public void setDianame(String dianame) {
		this.dianame = dianame;
	}

	public String getDateofDiagnosis() {
		return dateofDiagnosis;
	}

	public void setDateofDiagnosis(String dateofDiagnosis) {
		this.dateofDiagnosis = dateofDiagnosis;
	}

	public Set<PatientFollowupHistory> getPatientFollowupHistoryDetail() {
		return patientFollowupHistoryDetail;
	}

	public void setPatientFollowupHistoryDetail(Set<PatientFollowupHistory> patientFollowupHistoryDetail) {
		this.patientFollowupHistoryDetail = patientFollowupHistoryDetail;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "PatientDiagnosisHistory [pdhid=" + pdhid + ", dianame=" + dianame + ", dateofDiagnosis="
				+ dateofDiagnosis + ", patientFollowupHistoryDetail="
				+ (patientFollowupHistoryDetail != null ? toString(patientFollowupHistoryDetail, maxLen) : null)
				+ ", getPdhid()=" + getPdhid() + ", getDianame()=" + getDianame() + ", getDateofDiagnosis()="
				+ getDateofDiagnosis() + ", getPatientFollowupHistoryDetail()="
				+ (getPatientFollowupHistoryDetail() != null ? toString(getPatientFollowupHistoryDetail(), maxLen)
						: null)
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
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

	public PatientDiagnosisHistory(int pdhid, String dianame, String dateofDiagnosis,
			Set<PatientFollowupHistory> patientFollowupHistoryDetail) {
		super();
		this.pdhid = pdhid;
		this.dianame = dianame;
		this.dateofDiagnosis = dateofDiagnosis;
		this.patientFollowupHistoryDetail = patientFollowupHistoryDetail;
	}

	public PatientDiagnosisHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
