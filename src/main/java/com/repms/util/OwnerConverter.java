package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.Owner;
import com.repms.model.OwnerDTO;
@Component
public class OwnerConverter {
	public OwnerDTO convertToOwnerDTO(Owner owner) 
	{
		OwnerDTO oDto = new OwnerDTO();
        if(owner != null) 
        {
        	BeanUtils.copyProperties(owner, oDto);
            // Map other fields as needed
        }
        return oDto;
    }

    public Owner convertToOwnerEntity(OwnerDTO oDto) 
    {
    	Owner owner = new Owner();
        if(oDto != null) 
        {
        	BeanUtils.copyProperties(oDto, owner);
            // Map other fields as needed
        }
        return owner;
    }
}
