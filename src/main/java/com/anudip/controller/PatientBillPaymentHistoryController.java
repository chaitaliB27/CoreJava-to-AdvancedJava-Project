package com.anudip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.Entity.PatientBillPaymentHistory;
import com.anudip.Service.PatientBillPaymentHistoryService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/HospitalManagementSystem/PBPHC")
public class PatientBillPaymentHistoryController {
    @Autowired
	PatientBillPaymentHistoryService pbphs;
    
    @PostMapping("/addPatientBillPaymentHistorys")
	public ResponseEntity<PatientBillPaymentHistory> saveDoctors(@Valid @RequestBody PatientBillPaymentHistory patientBillPaymentHistory){
		return new ResponseEntity<PatientBillPaymentHistory>(pbphs.addPatientBillPaymentHistorys(patientBillPaymentHistory),
				HttpStatus.CREATED);
	}
    
    @GetMapping("/getPatientBillPaymentHistorys/{pbhid}")
	public ResponseEntity<PatientBillPaymentHistory> gesstudenss(@PathVariable("pbhid") int pbhid){
		return new ResponseEntity<PatientBillPaymentHistory>(pbphs.getPatientBillPaymentHistorysDetail(pbhid),HttpStatus.OK);
	}
   
   @DeleteMapping("/removePatientBillPaymentHistorys/{pbhid}")
	public ResponseEntity<String> deleteStudenss(@PathVariable("pbhid") int pbhid){
	   pbphs.deletePatientBillPaymentHistorysDetail(pbhid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
   
   @PutMapping("/editPatientBillPaymentHistorys/{did}")
	public ResponseEntity<PatientBillPaymentHistory> edisstudenss(@Valid @PathVariable("pbhid") int pbhid, @RequestBody PatientBillPaymentHistory patientBillPaymentHistory){
		return new ResponseEntity<PatientBillPaymentHistory>(pbphs.updatePatientBillPaymentHistorysDetail(patientBillPaymentHistory, pbhid), HttpStatus.OK);
	}
}
