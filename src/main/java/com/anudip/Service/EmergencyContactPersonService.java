package com.anudip.Service;

import com.anudip.Entity.EmergencyContactPerson;

public interface EmergencyContactPersonService {
    EmergencyContactPerson addEmergencyContactPersons(EmergencyContactPerson emergencyContactPerson);
	
	//method to fetch Students detail based on sid from db table
	EmergencyContactPerson getEmergencyContactPersonsDetail(int epid);
	
	//method to modify Students detail based on sid from db table
	EmergencyContactPerson updateEmergencyContactPersonsDetail(EmergencyContactPerson emergencyContactPerson, int epid);
	
	//method to remove Students detail based on sid from db table
	void deleteEmergencyContactPersonsDetail(int epid);
}
