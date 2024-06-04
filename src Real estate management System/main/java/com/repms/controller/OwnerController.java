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

import com.repms.service.Ownerservice;
import com.repms.util.OwnerConverter;
import com.repms.entity.Owner;
import com.repms.model.OwnerDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/REPMS/Owner")
public class OwnerController {
	@Autowired
	Ownerservice ownerservice;
    
    @Autowired
    OwnerConverter ownerConverter ;
    @PostMapping("/addOnwer")
    public OwnerDTO saveOnwer(@RequestBody OwnerDTO oDto) 
    {
    	Owner owner = ownerConverter.convertToOwnerEntity(oDto);
        return ownerservice.addOwner(owner);
    }
 	
 	@GetMapping("/getOnwer/{oit}")
 	public ResponseEntity<Owner> getOwner(@PathVariable("oit") int oit)
 	{
 		return new ResponseEntity<Owner>(ownerservice.getOwnersDetail(oit), HttpStatus.OK);
 	}
 	
 	@PutMapping("/updateOwner/{oit}")
 	public ResponseEntity<Owner>editOwner(@PathVariable("oit") int oit, @RequestBody Owner owner)
 	{
 		return new ResponseEntity<Owner>(ownerservice.updateOwnersDetail(owner, oit), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("/deleteOwner/{oit}")
 	public ResponseEntity<String> deleteAgent(@PathVariable("oit") int oit)
 	{
 		ownerservice.deleteOwnersDetail(oit);
 		return new ResponseEntity<String>("Owner Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("/getAllOwner")
 	public List<OwnerDTO> getAgents() {
 		
 		return ownerservice.getAllOnwer();
 	}
	
}
