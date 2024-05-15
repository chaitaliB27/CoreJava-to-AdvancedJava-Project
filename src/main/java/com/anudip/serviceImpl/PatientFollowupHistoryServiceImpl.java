package com.anudip.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anudip.Entity.PatientFollowupHistory;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.PatientFollowupHistoryRepository;
import com.anudip.Service.PatientFollowupHistoryService;

@Service
public class PatientFollowupHistoryServiceImpl implements PatientFollowupHistoryService{
	@Autowired
	PatientFollowupHistoryRepository pfhrepo;
	@Override
	public PatientFollowupHistory addPatientFollowupHistorys(PatientFollowupHistory patientFollowupHistory) {
		return pfhrepo.save(patientFollowupHistory);
	}

	@Override
	public PatientFollowupHistory getPatientFollowupHistorysDetail(int pfhid) {
		return pfhrepo.findById(pfhid).orElseThrow(()-> new IdNotFoundException("PatientFollowupHistory id is incorrect"));
	}

	@Override
	public PatientFollowupHistory updatePatientFollowupHistorysDetail(PatientFollowupHistory patientFollowupHistory,
			int pdhid) {
		PatientFollowupHistory updatedPatientFollowupHistory = pfhrepo.findById(pdhid).orElseThrow(()-> new IdNotFoundException("PatientFollowupHistory id is incorrect"));

		//set new values
		updatedPatientFollowupHistory.setDateoffollowup(patientFollowupHistory.getDateoffollowup());
		updatedPatientFollowupHistory.setPfhid(patientFollowupHistory.getPfhid());
		
		pfhrepo.save(updatedPatientFollowupHistory);
		return updatedPatientFollowupHistory;
	}

	@Override
	public void deletePatientFollowupHistorysDetail(int pdhid) {
		pfhrepo.findById(pdhid).orElseThrow(()-> new IdNotFoundException("PatientFollowupHistory id is incorrect"));
		pfhrepo.deleteById(pdhid);
		
	}

}
