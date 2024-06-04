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

import com.repms.entity.ClientRes;
import com.repms.model.ClientDTO;
import com.repms.service.ClientService;
import com.repms.util.ClientConverter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/REPMS/ClientRes")
public class ClientResController {
	@Autowired
	ClientService clientService;
    
    @Autowired
    ClientConverter clientConverter;
    
    @PostMapping("/addClientReg")
 	public ClientDTO saveClient(@RequestBody ClientDTO cDto) 
 	{	
    	ClientRes clientRes = clientConverter.convertToClientEntity(cDto);
 		return clientService.addClientRess(clientRes);
 	}
 	
 	@GetMapping("/getClientreg/{cit}")
 	public ResponseEntity<ClientRes> getClientReg(@PathVariable("cit") int cit)
 	{
 		return new ResponseEntity<ClientRes>(clientService.getClientRessDetail(cit), HttpStatus.OK);
 	}
 	
 	@PutMapping("/updateClientReg/{cit}")
 	public ResponseEntity<ClientRes>editClientReg(@PathVariable("cit") int cit, @RequestBody ClientRes ClientRes)
 	{
 		return new ResponseEntity<ClientRes>(clientService.updateClientRessDetail(ClientRes, cit), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("/deleteClientReg/{cit}")
 	public ResponseEntity<String> deleteClientReg(@PathVariable("cit") int cit)
 	{
 		clientService.deleteClientRessDetail(cit);
 		return new ResponseEntity<String>("Client Registation Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("/getAllClientReg")
 	public List<ClientDTO> getAgents() {
 		
 		return clientService.getAllClientRess();
 	}
}
