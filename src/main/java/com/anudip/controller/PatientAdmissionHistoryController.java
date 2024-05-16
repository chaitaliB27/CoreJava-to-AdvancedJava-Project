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

import com.anudip.Entity.PatientAdmissionHistory;
import com.anudip.Service.PatientAdmissionHistoryService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/PAHC")
public class PatientAdmissionHistoryController {
	@Autowired
	PatientAdmissionHistoryService pahs;
    
    @PostMapping("/addpahcs")

	public ResponseEntity<PatientAdmissionHistory> saveDepartment(@Valid @RequestBody PatientAdmissionHistory patientAdmissionHistory){
		return new ResponseEntity<PatientAdmissionHistory>(pahs.addPatientAdmissionHistorys(patientAdmissionHistory),
				HttpStatus.CREATED);
	}
    
    @GetMapping("/getpahcs/{pahid}")

	public ResponseEntity<PatientAdmissionHistory> getDepartment(@PathVariable("pahid") int pahid){
			return new ResponseEntity<PatientAdmissionHistory>(pahs.getPatientAdmissionHistorysDetail(pahid),HttpStatus.OK);
		}
    
    @DeleteMapping("/removpahcs/{pahid}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("pahid") int pahid){
    	pahs.deletePatientAdmissionHistorysDetail(pahid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	@PutMapping("/editpahcs/{pahid}")
	public ResponseEntity<PatientAdmissionHistory> editDepartment(@Valid @PathVariable("pahid") int pahid, @RequestBody PatientAdmissionHistory patientAdmissionHistory){
		return new ResponseEntity<PatientAdmissionHistory>(pahs.updatePatientAdmissionHistorysDetail(patientAdmissionHistory, pahid), HttpStatus.OK);
	}
}
