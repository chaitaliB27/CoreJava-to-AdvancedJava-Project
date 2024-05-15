package com.anudip.Service;

import com.anudip.Entity.HealthInsurance;

public interface HealthInsuranceService {
	HealthInsurance addHealthInsurances(HealthInsurance healthInsurance);
	
	//method to fetch Students detail based on sid from db table
	HealthInsurance getHealthInsurancesDetail(int hcid);
	
	//method to modify Students detail based on sid from db table
	HealthInsurance updateHealthInsurancesDetail(HealthInsurance healthInsurance, int hcid);
	
	//method to remove Students detail based on sid from db table
	void deleteHealthInsurancesDetail(int hcid);
}
