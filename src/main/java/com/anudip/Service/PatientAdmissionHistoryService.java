package com.anudip.Service;

import com.anudip.Entity.PatientAdmissionHistory;

public interface PatientAdmissionHistoryService {
PatientAdmissionHistory addPatientAdmissionHistorys(PatientAdmissionHistory PatientAdmissionHistory);
	
	//method to fetch Students detail based on sid from db table
	PatientAdmissionHistory getPatientAdmissionHistorysDetail(int pahid);
	
	//method to modify Students detail based on sid from db table
	PatientAdmissionHistory updatePatientAdmissionHistorysDetail(PatientAdmissionHistory PatientAdmissionHistory, int pahid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientAdmissionHistorysDetail(int pahid);
}
