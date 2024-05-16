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

import com.anudip.Entity.HealthInsurance;
import com.anudip.Service.HealthInsuranceService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/HealthInsurance")
public class HealthInsuranceController {
    @Autowired
	HealthInsuranceService hiser;
    @PostMapping("/addHealthInsurances")
	public ResponseEntity<HealthInsurance> saveDoctors(@Valid @RequestBody HealthInsurance healthInsurance){
		return new ResponseEntity<HealthInsurance>(hiser.addHealthInsurances(healthInsurance),
				HttpStatus.CREATED);
	}
    
    @GetMapping("/getHealthInsurances/{hcid}")
   	public ResponseEntity<HealthInsurance> gesstudenss(@PathVariable("hcid") int hcid){
   		return new ResponseEntity<HealthInsurance>(hiser.getHealthInsurancesDetail(hcid),HttpStatus.OK);
   	}
      
      @DeleteMapping("/removeHealthInsurances/{hcid}")
   	public ResponseEntity<String> deleteStudenss(@PathVariable("hcid") int hcid){
    	  hiser.deleteHealthInsurancesDetail(hcid);
   		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
   	}
      
      @PutMapping("/editHealthInsurances/{did}")
  	public ResponseEntity<HealthInsurance> edisstudenss(@Valid @PathVariable("hcid") int hcid, @RequestBody HealthInsurance healthInsurance){
  		return new ResponseEntity<HealthInsurance>(hiser.updateHealthInsurancesDetail(healthInsurance, hcid), HttpStatus.OK);
  	}
}
