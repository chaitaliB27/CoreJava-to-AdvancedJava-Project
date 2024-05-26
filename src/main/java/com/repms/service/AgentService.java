package com.repms.service;

import java.util.List;

import com.repms.entity.Agent;
import com.repms.model.AgentDTO;

public interface AgentService {
	AgentDTO addAgents(Agent agent);
	
	Agent getAgentsDetail(int aid);
	
	Agent updateAgentsDetail(Agent Agent, int aid);
	
	void deleteAgentsDetail(int aid);
	
	 List<AgentDTO> getAllAgent();

}
