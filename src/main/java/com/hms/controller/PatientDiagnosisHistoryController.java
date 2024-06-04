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

import com.hms.Entity.PatientDiagnosisHistory;
import com.hms.Service.PatientDiagnosisHistoryService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/pdhc")
public class PatientDiagnosisHistoryController {
	 @Autowired
		PatientDiagnosisHistoryService pdhs;
	    
	    @PostMapping("/addpdhcs")

		public ResponseEntity<PatientDiagnosisHistory> saveDepartment(@Valid @RequestBody PatientDiagnosisHistory patientDiagnosisHistory){
			return new ResponseEntity<PatientDiagnosisHistory>(pdhs.addPatientDiagnosisHistoryHistorys(patientDiagnosisHistory),
					HttpStatus.CREATED);
		}
	    @GetMapping("/getpdhcs/{pdhid}")

		public ResponseEntity<PatientDiagnosisHistory> getDepartment(@PathVariable("pdhid") int pdhid){
				return new ResponseEntity<PatientDiagnosisHistory>(pdhs.getPatientDiagnosisHistorysDetail(pdhid),HttpStatus.OK);
			}
	    
	    @DeleteMapping("/removpdhcs/{pdhid}")
	   	public ResponseEntity<String> deleteDepartment(@PathVariable("pdhid") int pfhid){
	    	pdhs.deletePatientDiagnosisHistorysDetail(pfhid);
	   		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	   	}
	       
	       @PutMapping("/editpdhcs/{pdhid}")
	   	public ResponseEntity<PatientDiagnosisHistory> editDepartment(@Valid @PathVariable("pdhid") int pdhid, @RequestBody PatientDiagnosisHistory patientDiagnosisHistory){
	   		return new ResponseEntity<PatientDiagnosisHistory>(pdhs.updatePatientDiagnosisHistorysDetail(patientDiagnosisHistory, pdhid), HttpStatus.OK);
	   	}
}
