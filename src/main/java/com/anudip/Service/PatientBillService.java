package com.anudip.Service;

import com.anudip.Entity.PatientBill;

public interface PatientBillService {
    PatientBill addPatientBills(PatientBill patientBill);
	
	//method to fetch Students detail based on sid from db table
	PatientBill getPatientBillsDetail(int pbid);
	
	//method to modify Students detail based on sid from db table
	PatientBill updatePatientBillsDetail(PatientBill patientBill, int pbid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientBillsDetail(int pbid);
}
