package com.hms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hms.Entity.PatientBill;
import com.hms.Exception.IdNotFoundException;
import com.hms.Repository.PatientBillrepository;
import com.hms.Service.PatientBillService;
@Service
public class PatientBilserviceImpl implements PatientBillService{
    @Autowired
	PatientBillrepository pbrepo;
	@Override
	public PatientBill addPatientBills(PatientBill patientBill) {
		return pbrepo.save(patientBill);
	}

	@Override
	public PatientBill getPatientBillsDetail(int pbid) {
		return pbrepo.findById(pbid).orElseThrow(()-> new IdNotFoundException("PatientBill id is incorrect"));
	}

	@Override
	public PatientBill updatePatientBillsDetail(PatientBill patientBill, int pbid) {
		PatientBill updatedPatientBill = pbrepo.findById(pbid).orElseThrow(()-> new IdNotFoundException("PatientBill id is incorrect"));

		//set new values
		updatedPatientBill.setPbid(patientBill.getPbid());
		updatedPatientBill.setPpayableAmount(patientBill.getPpayableAmount());
		updatedPatientBill.setHicpayableAmount(patientBill.getHicpayableAmount());
		pbrepo.save(updatedPatientBill);
		return updatedPatientBill;
	}

	@Override
	public void deletePatientBillsDetail(int pbid) {
		pbrepo.findById(pbid).orElseThrow(()-> new IdNotFoundException("PatientBill id is incorrect"));
		pbrepo.deleteById(pbid);
		
	}

}
