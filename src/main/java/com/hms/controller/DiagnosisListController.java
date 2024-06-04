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

import com.hms.Entity.HospitalDiagnosisList;
import com.hms.Service.HospitalDiagnosisListService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/ DiagnosisList")
public class DiagnosisListController {
	 @Autowired
		HospitalDiagnosisListService hdls;
	     
	     @PostMapping("/addDiagnosisListControllers")

	 	public ResponseEntity<HospitalDiagnosisList> saveDepartment(@Valid @RequestBody HospitalDiagnosisList hospitalDiagnosisList){
	 		return new ResponseEntity<HospitalDiagnosisList>(hdls.addHospitalDiagnosisListService(hospitalDiagnosisList),
	 				HttpStatus.CREATED);
	 	}
	     
	     @GetMapping("/getDiagnosisListControllers/{did}")

	 	public ResponseEntity<HospitalDiagnosisList> getDepartment(@PathVariable("did") int did){
	 			return new ResponseEntity<HospitalDiagnosisList>(hdls.getHospitalDiagnosisListService(did),HttpStatus.OK);
	 		}
	 	@DeleteMapping("/removeDiagnosisListControllers/{did}")
	 	public ResponseEntity<String> deleteDepartment(@PathVariable("did") int did){
	 		hdls.deleteHospitalDiagnosisListServicesDetail(did);
	 		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	 	}
	 	@PutMapping("/editDiagnosisListControllers/{sid}")
	 	public ResponseEntity<HospitalDiagnosisList> editDepartment(@Valid @PathVariable("did") int did, @RequestBody HospitalDiagnosisList hospitalDiagnosisList){
	 		return new ResponseEntity<HospitalDiagnosisList>(hdls.updateHospitalDiagnosisListServicesDetail(hospitalDiagnosisList, did), HttpStatus.OK);
	 	}
}
