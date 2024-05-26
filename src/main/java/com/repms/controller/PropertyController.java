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

import com.repms.entity.Property;
import com.repms.model.PropertyDTO;
import com.repms.service.PropertyService;
import com.repms.util.PropertyConverter;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/REPMS/Property")
public class PropertyController {
	@Autowired
	PropertyService propertyService;
    
    @Autowired
    PropertyConverter propertyConverter;
    
    @PostMapping("/addProperty")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO pDto) 
    {
    	Property property = propertyConverter.convertToPropertyEntity(pDto);
        return propertyService.addPropertys(property);
    }
 	
 	@GetMapping("/getProperty/{pit}")
 	public ResponseEntity<Property> getProperty(@PathVariable("pit") int pit)
 	{
 		return new ResponseEntity<Property>(propertyService.getPropertysDetail(pit), HttpStatus.OK);
 	}
 	
 	@PutMapping("/updateProperty/{pit}")
 	public ResponseEntity<Property>edidProperty(@PathVariable("pit") int pit, @RequestBody Property property)
 	{
 		return new ResponseEntity<Property>(propertyService.updatePropertysDetail(property, pit), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("/deleteProperty/{pit}")
 	public ResponseEntity<String> deleteProperty(@PathVariable("pit") int pit)
 	{
 		propertyService.deletePropertysDetail(pit);
 		return new ResponseEntity<String>("Agent Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("/getAllProperty")
 	public List<PropertyDTO> getPropertys() {
 		
 		return propertyService.getAllPropertys();
 	}
}
