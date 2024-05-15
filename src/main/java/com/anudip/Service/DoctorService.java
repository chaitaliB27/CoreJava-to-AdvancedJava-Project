package com.anudip.Service;

import java.util.List;


import com.anudip.Entity.Doctor;

public interface DoctorService {
	Doctor addDoctors(Doctor doctor);
	
	//method to fetch Students detail based on sid from db table
	Doctor getDoctorsDetail(int did);
	
	//method to modify Students detail based on sid from db table
	Doctor updateDoctorsDetail(Doctor doctor, int did);
	
	//method to remove Students detail based on sid from db table
	void deleteDoctorsDetail(int did);
	
	List<Doctor> getAllDoctor();
	
	Doctor getDoctorByPhone(long dphone);
	
	//method to fetch teacher details based on firstname
	List<Doctor> getDoctorByName(String dfname);
	
	//method to fetch teacher details based on first letter of teacher
		List<Doctor> getDoctorspecialization(String dspecialization);
}
