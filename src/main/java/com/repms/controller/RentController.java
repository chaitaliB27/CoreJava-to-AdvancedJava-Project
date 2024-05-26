package com.repms.controller;

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

import com.repms.entity.RentDeatils;
import com.repms.model.RentDetailsDTO;
import com.repms.service.RentDeatilsServices;
import com.repms.util.RentDetailsConverter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/REPMS/Rent")
public class RentController {
	@Autowired
	RentDeatilsServices rentDeatilsServices;
    
    @Autowired
    RentDetailsConverter rentDetailsConverter;
    
    @PostMapping("/addRent")
    public RentDetailsDTO saveAgent(@RequestBody RentDetailsDTO rDto) 
    {
    	RentDeatils rentDeatils = rentDetailsConverter.convertToRentDetailsEntity(rDto);
        return rentDeatilsServices.addRentDetails(rentDeatils);
    }
 	
 	@GetMapping("/getRent/{rit}")
 	public ResponseEntity<RentDeatils> getRent(@PathVariable("rit") int rit)
 	{
 		return new ResponseEntity<RentDeatils>(rentDeatilsServices.getRentsDetail(rit), HttpStatus.OK);
 	}
 	
 	@PutMapping("/updateRent/{rit}")
 	public ResponseEntity<RentDeatils>editAgent(@PathVariable("rit") int rid, @RequestBody RentDeatils rentDeatils)
 	{
 		return new ResponseEntity<RentDeatils>(rentDeatilsServices.updateRentsDetail(rentDeatils, rid), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("/deleteRent/{rit}")
 	public ResponseEntity<String> deleteAgent(@PathVariable("rit") int rit)
 	{
 		rentDeatilsServices.deleteRentsDetail(rit);
 		return new ResponseEntity<String>("Agent Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("/getAllRent")
 	public List<RentDetailsDTO> getAgents() {
 		
 		return rentDeatilsServices.getAllRentDetails();
 	}
}
