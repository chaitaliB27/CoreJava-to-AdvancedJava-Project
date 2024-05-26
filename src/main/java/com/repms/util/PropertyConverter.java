package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.Property;
import com.repms.model.PropertyDTO;
@Component
public class PropertyConverter {
	public PropertyDTO convertToPropertyDTO(Property property) 
	{
		PropertyDTO pDto = new PropertyDTO();
        if(property != null) 
        {
        	BeanUtils.copyProperties(property, pDto);
            // Map other fields as needed
        }
        return pDto;
    }

    public Property convertToPropertyEntity(PropertyDTO pDto) 
    {
    	Property property = new Property();
        if(pDto != null) 
        {
        	BeanUtils.copyProperties(pDto, property);
            // Map other fields as needed
        }
        return property;
    }
}
