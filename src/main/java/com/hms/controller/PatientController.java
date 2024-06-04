package com.hms.controller;

import java.util.List;

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

import com.hms.Entity.Patient;
import com.hms.Service.PatientService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/Patient")
public class PatientController {
    @Autowired
	PatientService ps;
    
    @PostMapping("/patients")
	public ResponseEntity<Patient> savePtients(@Valid @RequestBody Patient patient){
		return new ResponseEntity<Patient>(ps.addPatients(patient),
				HttpStatus.CREATED);
	}
    
    @GetMapping("/patients/{pid}")
	public ResponseEntity<Patient> getPatients(@PathVariable("pid") int pid){
		return new ResponseEntity<Patient>(ps.getPatientsDetail(pid),HttpStatus.OK);
	}
    
    @DeleteMapping("/patients/{pid}")
	public ResponseEntity<String> deletePatients(@PathVariable("pid") int pid){
    	ps.deletePatientsDetail(pid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
    
    @PutMapping("/patients/{pid}")
	public ResponseEntity<Patient> editPatients(@Valid @PathVariable("pid") int pid, @RequestBody Patient patient){
		return new ResponseEntity<Patient>(ps.updatePatientsDetail(patient, pid), HttpStatus.OK);
	}
    
    @GetMapping("/patients")
	public List<Patient> getPatient(){
		return ps.getAllPatient();
	}
}
