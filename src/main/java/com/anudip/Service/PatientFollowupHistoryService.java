package com.anudip.Service;

import com.anudip.Entity.PatientFollowupHistory;

public interface PatientFollowupHistoryService {
PatientFollowupHistory addPatientFollowupHistorys(PatientFollowupHistory patientFollowupHistory);
	
	//method to fetch Students detail based on sid from db table
	PatientFollowupHistory getPatientFollowupHistorysDetail(int pfhid);
	
	//method to modify Students detail based on sid from db table
	PatientFollowupHistory updatePatientFollowupHistorysDetail(PatientFollowupHistory patientFollowupHistory, int pfhid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientFollowupHistorysDetail(int pfhid);
}
