package com.anudip.Service;

import com.anudip.Entity.PatientBillPaymentHistory;

public interface PatientBillPaymentHistoryService {
	PatientBillPaymentHistory addPatientBillPaymentHistorys(PatientBillPaymentHistory patientBillPaymentHistory);
	
	//method to fetch Students detail based on sid from db table
	PatientBillPaymentHistory getPatientBillPaymentHistorysDetail(int pbhid);
	
	//method to modify Students detail based on sid from db table
	PatientBillPaymentHistory updatePatientBillPaymentHistorysDetail(PatientBillPaymentHistory patientBillPaymentHistory, int pbhid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientBillPaymentHistorysDetail(int pbhid);
}
