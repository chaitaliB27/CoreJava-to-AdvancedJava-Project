package com.hms.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.hms.Entity.PatientDiagnosisHistory;
import com.hms.Exception.IdNotFoundException;
import com.hms.Repository.PatientDiagnosisHistoryRepository;
import com.hms.Service.PatientDiagnosisHistoryService;


@Service
public class PatientDiagnosisHistoryServiceImpl implements PatientDiagnosisHistoryService{
	@Autowired
	PatientDiagnosisHistoryRepository pdhrepo;
	@Override
	public PatientDiagnosisHistory addPatientDiagnosisHistoryHistorys(PatientDiagnosisHistory PatientDiagnosisHistory) {
		return pdhrepo.save(PatientDiagnosisHistory);
	}

	@Override
	public PatientDiagnosisHistory getPatientDiagnosisHistorysDetail(int pfhid) {
		return pdhrepo.findById(pfhid).orElseThrow(()-> new IdNotFoundException("PatientDiagnosisHistory id is incorrect"));
	}

	@Override
	public PatientDiagnosisHistory updatePatientDiagnosisHistorysDetail(PatientDiagnosisHistory PatientDiagnosisHistory,
			int pdhid) {
		PatientDiagnosisHistory updatedPatientDiagnosisHistory = pdhrepo.findById(pdhid).orElseThrow(()-> new IdNotFoundException("PatientDiagnosisHistory id is incorrect"));

		//set new values
		updatedPatientDiagnosisHistory.setDateofDiagnosis(PatientDiagnosisHistory.getDateofDiagnosis());
		updatedPatientDiagnosisHistory.setPdhid(PatientDiagnosisHistory.getPdhid());
		
		pdhrepo.save(updatedPatientDiagnosisHistory);
		return updatedPatientDiagnosisHistory;
	}

	@Override
	public void deletePatientDiagnosisHistorysDetail(int pdhid) 
	{
		pdhrepo.findById(pdhid).orElseThrow(()-> new IdNotFoundException ("PatientDiagnosisHistory id is incorrect"));
		pdhrepo.deleteById(pdhid);
		
	}

}
