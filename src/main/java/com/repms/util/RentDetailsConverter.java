package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.RentDeatils;
import com.repms.model.RentDetailsDTO;
@Component
public class RentDetailsConverter {
	public RentDetailsDTO convertToRentDetailsDTO(RentDeatils rentDeatils) 
	{
		RentDetailsDTO rdDto = new RentDetailsDTO();
        if(rentDeatils != null) 
        {
        	BeanUtils.copyProperties(rentDeatils, rdDto);
            // Map other fields as needed
        }
        return rdDto;
    }

    public RentDeatils convertToRentDetailsEntity(RentDetailsDTO rdDto) 
    {
    	RentDeatils rentDeatils = new RentDeatils();
        if(rdDto != null) 
        {
        	BeanUtils.copyProperties(rdDto, rentDeatils);
            // Map other fields as needed
        }
        return rentDeatils;
    }
}
