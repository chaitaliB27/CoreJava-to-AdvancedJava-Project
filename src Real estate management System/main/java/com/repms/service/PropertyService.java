package com.repms.service;

import java.util.List;

import com.repms.entity.Property;
import com.repms.model.PropertyDTO;

public interface PropertyService {
	PropertyDTO addPropertys(Property property);
	
	Property getPropertysDetail(int pid);
	
	Property updatePropertysDetail(Property property, int pid);
	
	void deletePropertysDetail(int pid);
	
	List<PropertyDTO> getAllPropertys();
}
