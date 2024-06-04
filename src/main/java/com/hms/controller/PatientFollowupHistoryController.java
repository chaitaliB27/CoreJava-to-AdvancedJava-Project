package com.hms.controller;
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

import com.hms.Entity.PatientFollowupHistory;
import com.hms.Service.PatientFollowupHistoryService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/PFUHC")
public class PatientFollowupHistoryController {
	@Autowired
	PatientFollowupHistoryService pfuhs;
    
    @PostMapping("/addpfuhs")

	public ResponseEntity<PatientFollowupHistory> saveDepartment(@Valid @RequestBody PatientFollowupHistory patientFollowupHistory){
		return new ResponseEntity<PatientFollowupHistory>(pfuhs.addPatientFollowupHistorys(patientFollowupHistory),
				HttpStatus.CREATED);
	}
    
    @GetMapping("/getpahcs/{pfhid}")

	public ResponseEntity<PatientFollowupHistory> getDepartment(@PathVariable("pfhid") int pfhid){
			return new ResponseEntity<PatientFollowupHistory>(pfuhs.getPatientFollowupHistorysDetail(pfhid),HttpStatus.OK);
		}
    
    @DeleteMapping("/removpahcs/{pfhid}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("pfhid") int pfhid){
    	pfuhs.deletePatientFollowupHistorysDetail(pfhid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
    
    @PutMapping("/editpahcs/{pfhid}")
	public ResponseEntity<PatientFollowupHistory> editDepartment(@Valid @PathVariable("pfhid") int pfhid, @RequestBody PatientFollowupHistory patientFollowupHistory){
		return new ResponseEntity<PatientFollowupHistory>(pfuhs.updatePatientFollowupHistorysDetail(patientFollowupHistory, pfhid), HttpStatus.OK);
	}
}
