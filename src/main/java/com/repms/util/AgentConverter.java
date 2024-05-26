package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.Agent;
import com.repms.model.AgentDTO;
@Component
public class AgentConverter {
	public AgentDTO convertToAgentDTO(Agent agent) 
	{
		AgentDTO agent1 = new AgentDTO();
        if(agent1 != null) 
        {
        	BeanUtils.copyProperties(agent1, agent1);
            // Map other fields as needed
        }
        return agent1;
    }

    public Agent convertToAgentEntity(AgentDTO aDto) 
    {
    	Agent agent = new Agent();
        if(aDto != null) 
        {
        	BeanUtils.copyProperties(aDto, agent);
            // Map other fields as needed
        }
        return agent;
    }
}
