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

import com.hms.Entity.Nurse;
import com.hms.Service.NursesService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/Nurse")
public class NurseController {
	@Autowired
	NursesService ns;
		
	@PostMapping("/nurses")
		
		public ResponseEntity<Nurse> saveStudenss(@Valid @RequestBody Nurse nurse){
			return new ResponseEntity<Nurse>(ns.addNurses(nurse),
					HttpStatus.CREATED);
		}

	@GetMapping("/nurses/{nid}")

	public ResponseEntity<Nurse> gesstudenss(@PathVariable("nid") int nid){
			return new ResponseEntity<Nurse>(ns.getNursesDetail(nid),HttpStatus.OK);
		}
	@DeleteMapping("/nurses/{nid}")
	public ResponseEntity<String> deleteStudenss(@PathVariable("nid") int nid){
		ns.deleteNursesDetail(nid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	@PutMapping("/nurses/{nid}")
	public ResponseEntity<Nurse> edisstudenss(@Valid @PathVariable("nid") int nid, @RequestBody Nurse nurse){
		return new ResponseEntity<Nurse>(ns.updateNursesDetail(nurse, nid), HttpStatus.OK);
	}
	
	@GetMapping("/nurses")
	public List<Nurse> getNurse(){
		return ns.getAllNurse();
	}
}
