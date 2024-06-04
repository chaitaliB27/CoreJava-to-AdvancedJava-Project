package com.hms.Service;

import com.hms.Entity.PatientHistory;

public interface PatientHistoryService {
	PatientHistory addPatientHistorys(PatientHistory patientHistory);
	
	//method to fetch Students detail based on sid from db table
	PatientHistory getPatientHistorysDetail(int phid);
	
	//method to modify Students detail based on sid from db table
	PatientHistory updatePatientHistorysDetail(PatientHistory patientHistory, int phid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientHistorysDetail(int phid);
}
