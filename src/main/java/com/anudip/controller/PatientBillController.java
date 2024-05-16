package com.anudip.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.Entity.PatientBill;
import com.anudip.Service.PatientBillService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/PatientBill")
public class PatientBillController {
    @Autowired
	PatientBillService pbs;
    
    @PostMapping("/addPatientBills")
	public ResponseEntity<PatientBill> saveDoctors(@Valid @RequestBody PatientBill patientBill){
		return new ResponseEntity<PatientBill>(pbs.addPatientBills(patientBill),
				HttpStatus.CREATED);
	}
    
    @GetMapping("/getPatientBills/{pbid}")
	public ResponseEntity<PatientBill> gesstudenss(@PathVariable("pbid") int pbid){
		return new ResponseEntity<PatientBill>(pbs.getPatientBillsDetail(pbid),HttpStatus.OK);
	}
    
    @DeleteMapping("/removePatientBills/{pbid}")
	public ResponseEntity<String> deleteStudenss(@PathVariable("pbid") int pbid){
    	pbs.deletePatientBillsDetail(pbid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
    
    @PutMapping("/editPatientBills/{pbid}")
	public ResponseEntity<PatientBill> edisstudenss(@Valid @PathVariable("pbid") int pbid, @RequestBody PatientBill patientBill){
		return new ResponseEntity<PatientBill>(pbs.updatePatientBillsDetail(patientBill, pbid), HttpStatus.OK);
	}
}
