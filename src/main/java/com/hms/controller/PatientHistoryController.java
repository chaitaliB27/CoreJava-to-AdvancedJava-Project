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

import com.hms.Entity.PatientHistory;
import com.hms.Service.PatientHistoryService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/PatientHistory")
public class PatientHistoryController {
	@Autowired
	PatientHistoryService phs;
    
    @PostMapping("/addphcs")

   	public ResponseEntity<PatientHistory> saveDepartment(@Valid @RequestBody PatientHistory patientHistory){
   		return new ResponseEntity<PatientHistory>(phs.addPatientHistorys(patientHistory),
   				HttpStatus.CREATED);
   	}
       
       @GetMapping("/getphcs/{phid}")

   	public ResponseEntity<PatientHistory> getDepartment(@PathVariable("phid") int phid){
   			return new ResponseEntity<PatientHistory>(phs.getPatientHistorysDetail(phid),HttpStatus.OK);
   		}
       
       @DeleteMapping("/removephcs/{pfhid}")
   	public ResponseEntity<String> deleteDepartment(@PathVariable("phid") int phid){
    	   phs.deletePatientHistorysDetail(phid);
   		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
   	}
       
       @PutMapping("/editphccs/{pfhid}")
   	public ResponseEntity<PatientHistory> editDepartment(@Valid @PathVariable("phid") int phid, @RequestBody PatientHistory patientHistory){
   		return new ResponseEntity<PatientHistory>(phs.updatePatientHistorysDetail(patientHistory, phid), HttpStatus.OK);
   	}
}
