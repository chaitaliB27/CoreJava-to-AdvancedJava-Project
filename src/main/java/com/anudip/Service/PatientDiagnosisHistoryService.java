package com.anudip.Service;

import com.anudip.Entity.PatientDiagnosisHistory;

public interface PatientDiagnosisHistoryService {
PatientDiagnosisHistory addPatientDiagnosisHistoryHistorys(PatientDiagnosisHistory PatientDiagnosisHistory);
	
	//method to fetch Students detail based on sid from db table
	PatientDiagnosisHistory getPatientDiagnosisHistorysDetail(int pdhid);
	
	//method to modify Students detail based on sid from db table
	PatientDiagnosisHistory updatePatientDiagnosisHistorysDetail(PatientDiagnosisHistory PatientDiagnosisHistory, int pdhid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientDiagnosisHistorysDetail(int pdhid);
}
