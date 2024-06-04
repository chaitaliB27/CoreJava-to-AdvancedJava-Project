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

import com.repms.entity.Agent;
import com.repms.model.AgentDTO;
import com.repms.service.AgentService;
import com.repms.util.AgentConverter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/REPMS/Agent")
public class AgentController {
	@Autowired
	AgentService agentService;
    
    @Autowired
    AgentConverter agentConverter;
    
    // http://localhost:8080/ims/Admin/addAdmin
    @PostMapping("/addAgent")
    public AgentDTO saveAgent(@RequestBody AgentDTO aDto) 
    {
        Agent agent = agentConverter.convertToAgentEntity(aDto);
        return agentService.addAgents(agent);
    }
 	
 	@GetMapping("/getAgent/{ait}")
 	public ResponseEntity<Agent> getAgent(@PathVariable("aid") int aid)
 	{
 		return new ResponseEntity<Agent>(agentService.getAgentsDetail(aid), HttpStatus.OK);
 	}
 	
 	@PutMapping("/updateAgent/{ait}")
 	public ResponseEntity<Agent>editAgent(@PathVariable("ait") int aid, @RequestBody Agent agent)
 	{
 		return new ResponseEntity<Agent>(agentService.updateAgentsDetail(agent, aid), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("/deleteAgent/{ait}")
 	public ResponseEntity<String> deleteAgent(@PathVariable("ait") int ait)
 	{
 		agentService.deleteAgentsDetail(ait);
 		return new ResponseEntity<String>("Agent Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("/getAllAgent")
 	public List<AgentDTO> getAgents() {
 		
 		return agentService.getAllAgent();
 	}
}
