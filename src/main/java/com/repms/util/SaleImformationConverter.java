package com.repms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.repms.entity.SaleImformation;
import com.repms.model.SaleImformationDTO;
@Component
public class SaleImformationConverter {
	public SaleImformationDTO convertToSaleImformationDTO(SaleImformation saleImformation) 
	{
		SaleImformationDTO siDto = new SaleImformationDTO();
        if(saleImformation != null) 
        {
        	BeanUtils.copyProperties(saleImformation, siDto);
            // Map other fields as needed
        }
        return siDto;
    }

    public SaleImformation convertToSaleImformationEntity(SaleImformationDTO siDto) 
    {
    	SaleImformation saleImformation = new SaleImformation();
        if(siDto != null) 
        {
        	BeanUtils.copyProperties(siDto, saleImformation);
            // Map other fields as needed
        }
        return saleImformation;
    }
}
