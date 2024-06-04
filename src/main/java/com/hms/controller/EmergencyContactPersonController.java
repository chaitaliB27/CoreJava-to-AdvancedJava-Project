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

import com.hms.Entity.EmergencyContactPerson;
import com.hms.Service.EmergencyContactPersonService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/ECPC")
public class EmergencyContactPersonController {
	@Autowired
	EmergencyContactPersonService ECPS;
	
@PostMapping("/addECPC")
public ResponseEntity<EmergencyContactPerson> saveDepartment(@Valid @RequestBody EmergencyContactPerson emergencyContactPerson){
		return new ResponseEntity<EmergencyContactPerson>(ECPS.addEmergencyContactPersons(emergencyContactPerson),
				HttpStatus.CREATED);
	}

@GetMapping("/getECPC/{epid}")

public ResponseEntity<EmergencyContactPerson> getDepartment(@PathVariable("epid") int epid){
		return new ResponseEntity<EmergencyContactPerson>(ECPS.getEmergencyContactPersonsDetail(epid),HttpStatus.OK);
	}
@DeleteMapping("/removeECPC/{epid}")
public ResponseEntity<String> deleteDepartment(@PathVariable("epid") int epid){
	ECPS.deleteEmergencyContactPersonsDetail(epid);
	return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
}

@PutMapping("/editECPC/{epid}")
public ResponseEntity<EmergencyContactPerson> editDepartment(@Valid @PathVariable("epid") int epid, @RequestBody EmergencyContactPerson emergencyContactPerson){
	return new ResponseEntity<EmergencyContactPerson>(ECPS.updateEmergencyContactPersonsDetail(emergencyContactPerson, epid), HttpStatus.OK);
}
}
