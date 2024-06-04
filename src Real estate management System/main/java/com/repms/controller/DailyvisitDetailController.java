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

import com.repms.entity.DailyvisitDetails;
import com.repms.model.DailyVisitDetailsDTO;
import com.repms.service.DailyvisitDetailsservice;
import com.repms.util.DailyvisitDetailsConverter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/REPMS/DailyvisitDetail")
public class DailyvisitDetailController {
	@Autowired
	DailyvisitDetailsservice dailyvisitDetailsservice;
    
    @Autowired
    DailyvisitDetailsConverter dailyvisitDetailsConverter;
    
	
    // http://localhost:8080/ims/Admin/addAdmin
    @PostMapping("/adddailyvisitDetails")
    public DailyVisitDetailsDTO saveDailyVisitDetails(@RequestBody DailyVisitDetailsDTO dvsDto) {
    	DailyvisitDetails dailyvisitDetails = dailyvisitDetailsConverter.convertToDailyvisitDetailsEntity(dvsDto);
        return dailyvisitDetailsservice.addDailyvisitDetails(dailyvisitDetails);
    }
 	
 	@GetMapping("/getdailyvisitDetails/{dvit}")
 	public ResponseEntity<DailyvisitDetails> getDailyvisitDetails(@PathVariable("dvit") int dvit)
 	{
 		return new ResponseEntity<DailyvisitDetails>(dailyvisitDetailsservice.getDailyvisitDetailssDetail(dvit), HttpStatus.OK);
 	}
 	
 	@PutMapping("/updatedailyvisitDetails/{dvit}")
 	public ResponseEntity<DailyvisitDetails>editDailyvisitDetails(@PathVariable("dvit") int dvit, @RequestBody DailyvisitDetails dailyvisitDetails)
 	{
 		return new ResponseEntity<DailyvisitDetails>(dailyvisitDetailsservice.updateDailyvisitDetails(dailyvisitDetails, dvit), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("/deletedailyvisitDetails/{dvit}")
 	public ResponseEntity<String> deleteAgent(@PathVariable("dvit") int dvit)
 	{
 		dailyvisitDetailsservice.deleteDailyvisitDetails(dvit);
 		return new ResponseEntity<String>("Agent Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("/getAlldailyvisitDetails")
 	public List<DailyVisitDetailsDTO> getAgents() {
 		
 		return dailyvisitDetailsservice.getAllDailyvisitDetails();
 	}
}
