package com.anudip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anudip.Entity.PatientHistory;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.PatientHistoryRepository;
import com.anudip.Service.PatientHistoryService;
@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{
    @Autowired
	PatientHistoryRepository phrepo;
	@Override
	public PatientHistory addPatientHistorys(PatientHistory patientHistory) {
		return phrepo.save(patientHistory);
	}

	@Override
	public PatientHistory getPatientHistorysDetail(int phid) {
		return phrepo.findById(phid).orElseThrow(()-> new IdNotFoundException("PatientHistory id is incorrect"));
	}

	@Override
	public PatientHistory updatePatientHistorysDetail(PatientHistory patientHistory, int phid) {
		PatientHistory updatePatientHistory = phrepo.findById(phid).orElseThrow(()-> new IdNotFoundException("PatientHistory id is incorrect"));

		//set new values
		updatePatientHistory.setPhid(patientHistory.getPhid());
		updatePatientHistory.setDateoftreatement(patientHistory.getDateoftreatement());
	
		phrepo.save(updatePatientHistory);
		return updatePatientHistory;
	}

	@Override
	public void deletePatientHistorysDetail(int phid) {
		phrepo.findById(phid).orElseThrow(()-> new IdNotFoundException("PatientHistory id is incorrect"));
		phrepo.deleteById(phid);
		
		
	}

}
