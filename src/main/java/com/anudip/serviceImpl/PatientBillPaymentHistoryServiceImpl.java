package com.anudip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anudip.Entity.PatientBillPaymentHistory;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.PatientBillPaymentHistoryrepository;
import com.anudip.Service.PatientBillPaymentHistoryService;
@Service
public class PatientBillPaymentHistoryServiceImpl implements PatientBillPaymentHistoryService{
	@Autowired
	PatientBillPaymentHistoryrepository pbphrepo;
	@Override
	public PatientBillPaymentHistory addPatientBillPaymentHistorys(
			PatientBillPaymentHistory patientBillPaymentHistory) {
		return pbphrepo.save(patientBillPaymentHistory);
	}

	@Override
	public PatientBillPaymentHistory getPatientBillPaymentHistorysDetail(int pbhid) {
		return pbphrepo.findById(pbhid).orElseThrow(()-> new IdNotFoundException("PatientBillPaymentHistory id is incorrect"));
	}

	@Override
	public PatientBillPaymentHistory updatePatientBillPaymentHistorysDetail(
			PatientBillPaymentHistory patientBillPaymentHistory, int pbhid) {
		PatientBillPaymentHistory updatePatientBillPaymentHistory = pbphrepo.findById(pbhid).orElseThrow(()-> new IdNotFoundException("PatientBillPaymentHistory id is incorrect"));

		//set new values
		updatePatientBillPaymentHistory.setPbhid(patientBillPaymentHistory.getPbhid());
		updatePatientBillPaymentHistory.setAmount(patientBillPaymentHistory.getAmount());
		updatePatientBillPaymentHistory.setPatientPaid(patientBillPaymentHistory.getPatientPaid());
		updatePatientBillPaymentHistory.setInsurancePaid(patientBillPaymentHistory.getInsurancePaid());
		updatePatientBillPaymentHistory.setDateofpayment(patientBillPaymentHistory.getDateofpayment());
		
		pbphrepo.save(updatePatientBillPaymentHistory);
		return updatePatientBillPaymentHistory;
	}

	@Override
	public void deletePatientBillPaymentHistorysDetail(int pbhid) {
		pbphrepo.findById(pbhid).orElseThrow(()-> new IdNotFoundException("PatientBillPaymentHistory id is incorrect"));
		pbphrepo.deleteById(pbhid);
		
	}
}
