package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.DailyvisitDetails;
import com.repms.model.DailyVisitDetailsDTO;
@Component
public class DailyvisitDetailsConverter {
	public DailyVisitDetailsDTO convertToDailyvisitDetailsDTO(DailyvisitDetails dailyvisitDetails) 
	{
		DailyVisitDetailsDTO aDto = new DailyVisitDetailsDTO();
        if(dailyvisitDetails != null) 
        {
        	BeanUtils.copyProperties(dailyvisitDetails, aDto);
            // Map other fields as needed
        }
        return aDto;
    }

    public DailyvisitDetails convertToDailyvisitDetailsEntity(DailyVisitDetailsDTO dvDto) 
    {
    	DailyvisitDetails dailyvisitDetails = new DailyvisitDetails();
        if(dvDto != null) 
        {
        	BeanUtils.copyProperties(dvDto, dailyvisitDetails);
            // Map other fields as needed
        }
        return dailyvisitDetails;
    }
}
