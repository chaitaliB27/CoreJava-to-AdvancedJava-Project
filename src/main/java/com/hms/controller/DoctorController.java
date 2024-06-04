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

import com.hms.Entity.Doctor;
import com.hms.Service.DoctorService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController

@RequestMapping("/HospitalManagementSystem/Doctor")
public class DoctorController {
   @Autowired
	DoctorService ds;
   
   @PostMapping("/doctors")
	public ResponseEntity<Doctor> saveDoctors(@Valid @RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(ds.addDoctors(doctor),
				HttpStatus.CREATED);
	}
   
   @GetMapping("/doctors/{did}")
	public ResponseEntity<Doctor> gesstudenss(@PathVariable("did") int did){
		return new ResponseEntity<Doctor>(ds.getDoctorsDetail(did),HttpStatus.OK);
	}
   
   @DeleteMapping("/doctors/{did}")
	public ResponseEntity<String> deleteStudenss(@PathVariable("did") int did){
	   ds.deleteDoctorsDetail(did);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
   
   @GetMapping("/doctors")
	public List<Doctor> getDoctor(){
		return ds.getAllDoctor();
	}
   
   @PutMapping("/doctors/{did}")
	public ResponseEntity<Doctor> edisstudenss(@Valid @PathVariable("did") int did, @RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(ds.updateDoctorsDetail(doctor, did), HttpStatus.OK);
	}
   @GetMapping("doctors/getdName/{dfname}")
   public List<Doctor> getTeacherName(@PathVariable("dfname") String dfname){
		return ds.getDoctorByName(dfname);
	}
	
	@GetMapping("doctors/getDPhone/{dphone}")
	public ResponseEntity<Doctor> getTeacherPhone(@PathVariable("dphone") long dphone){
		return new ResponseEntity<Doctor>(ds.getDoctorByPhone(dphone), HttpStatus.OK);
	}
	
	
	@GetMapping("doctors/getDspecialization/{dspecialization}")
	public List<Doctor> getTeacherDesignation(@PathVariable("dspecialization") String dspecialization){
		return ds.getDoctorspecialization(dspecialization);
	}
}
