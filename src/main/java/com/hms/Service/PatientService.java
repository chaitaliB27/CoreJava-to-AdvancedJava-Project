package com.hms.Service;

import java.util.List;

import com.hms.Entity.Patient;


public interface PatientService {
	Patient addPatients(Patient patient);
	
	//method to fetch Students detail based on sid from db table
	Patient getPatientsDetail(int pid);
	
	//method to modify Students detail based on sid from db table
	Patient updatePatientsDetail(Patient patient, int pid);
	
	//method to remove Students detail based on sid from db table
	void deletePatientsDetail(int pid);
	
	List<Patient> getAllPatient();
}
