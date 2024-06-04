package com.repms.serviceImpl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.repms.entity.Agent;
import com.repms.exception.IdNotFoundException;
import com.repms.model.AgentDTO;
import com.repms.repository.AgentRepository;
import com.repms.service.AgentService;
import com.repms.util.AgentConverter;
@Service
public class AgentServiceImpl implements AgentService{
    @Autowired
	AgentRepository arepo;

    @Autowired
    private AgentConverter agentConverter;
	@Override
	public AgentDTO addAgents(Agent agent) {
		arepo.save(agent);
		return agentConverter.convertToAgentDTO(agent);
	}

	@Override
	public Agent getAgentsDetail(int aid) {
		return arepo.findById(aid).orElseThrow( ()-> new IdNotFoundException("Agent id is not found"));
	}

	@Override
	public Agent updateAgentsDetail(Agent agent, int aid) {
		Agent updateagent = arepo.findById(aid).orElseThrow( ()-> new IdNotFoundException("Agent id is not correct"));
		updateagent.setAit(agent.getAit());
		updateagent.setAfname(agent.getAfname());
		updateagent.setAlname(agent.getAlname());
		updateagent.setAphone(agent.getAphone());
		updateagent.setAemail(agent.getAemail());
		arepo.save(updateagent);
		
		return updateagent;
	}

	@Override
	public void deleteAgentsDetail(int aid) {
		arepo.findById(aid).orElseThrow( ()-> new IdNotFoundException("Agent id is not correct"));
		arepo.deleteById(aid);
		
	}

	@Override
	public List<AgentDTO> getAllAgent() {
     List<Agent> Agent = arepo.findAll();
		
		List<AgentDTO> dtoList = new ArrayList<>();
		for(Agent a: Agent)
		{
			dtoList.add(agentConverter.convertToAgentDTO(a));
		}
		return dtoList;
	}
	
}
