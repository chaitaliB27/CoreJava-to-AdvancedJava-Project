package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.ClientRes;
import com.repms.model.ClientDTO;
@Component
public class ClientConverter {
	public ClientDTO convertToClientDTO(ClientRes clientRes) 
	{
		ClientDTO aDto = new ClientDTO();
        if(clientRes != null) 
        {
        	BeanUtils.copyProperties(clientRes, aDto);
            // Map other fields as needed
        }
        return aDto;
    }

    public ClientRes convertToClientEntity(ClientDTO aDto) 
    {
    	ClientRes clientRes = new ClientRes();
        if(aDto != null) 
        {
        	BeanUtils.copyProperties(aDto, clientRes);
            // Map other fields as needed
        }
        return clientRes;
    }
}
