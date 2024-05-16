package com.anudip.Service;

import com.anudip.Entity.HospitalDiagnosisList;

public interface HospitalDiagnosisListService {
	HospitalDiagnosisList addHospitalDiagnosisListService(HospitalDiagnosisList hospitalDiagnosisList);
	
	//method to fetch Students detail based on sid from db table
HospitalDiagnosisList getHospitalDiagnosisListService(int hdid);
	
	//method to modify Students detail based on sid from db table
HospitalDiagnosisList updateHospitalDiagnosisListServicesDetail(HospitalDiagnosisList hospitalDiagnosisList, int hdid);
	
	//method to remove Students detail based on sid from db table
	void deleteHospitalDiagnosisListServicesDetail(int hdid);
}

