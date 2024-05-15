package com.anudip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anudip.Entity.PatientAdmissionHistory;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.PatientAdmissionHistoryRepository;
import com.anudip.Service.PatientAdmissionHistoryService;
@Service
public class PatientAdmissionHistoryServiceImpl implements PatientAdmissionHistoryService{
	@Autowired
	PatientAdmissionHistoryRepository pahrepo;

	@Override
	public PatientAdmissionHistory addPatientAdmissionHistorys(PatientAdmissionHistory PatientAdmissionHistory) {
		return pahrepo.save(PatientAdmissionHistory);
	}

	@Override
	public PatientAdmissionHistory getPatientAdmissionHistorysDetail(int pahid) {
		return pahrepo.findById(pahid).orElseThrow(()-> new IdNotFoundException("PatientAdmissionHistory id is incorrect"));
	}

	@Override
	public PatientAdmissionHistory updatePatientAdmissionHistorysDetail(PatientAdmissionHistory PatientAdmissionHistory,int pahid) {
		PatientAdmissionHistory updatedPatientAdmissionHistory = pahrepo.findById(pahid).orElseThrow(()-> new IdNotFoundException("PatientAdmissionHistory id is incorrect"));

		//set new values
		updatedPatientAdmissionHistory.setPahid(PatientAdmissionHistory.getPahid());
		updatedPatientAdmissionHistory.setAdmission_date(PatientAdmissionHistory.getAdmission_date());
		updatedPatientAdmissionHistory.setBed_No(PatientAdmissionHistory.getBed_No());
		updatedPatientAdmissionHistory.setWard_No(PatientAdmissionHistory.getWard_No());
		updatedPatientAdmissionHistory.setTatalCost(PatientAdmissionHistory.getTatalCost());
		updatedPatientAdmissionHistory.setDischarge_date(PatientAdmissionHistory.getDischarge_date());
		pahrepo.save(updatedPatientAdmissionHistory);
		return updatedPatientAdmissionHistory;
	}

	@Override
	public void deletePatientAdmissionHistorysDetail(int pahid) {
		pahrepo.findById(pahid).orElseThrow(()-> new IdNotFoundException("PatientAdmissionHistory id is incorrect"));
		pahrepo.deleteById(pahid);
		
	}
}
