package com.repms.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.repms.entity.Property;
import com.repms.exception.IdNotFoundException;
import com.repms.model.PropertyDTO;
import com.repms.repository.PropertyRepository;
import com.repms.service.PropertyService;
import com.repms.util.PropertyConverter;
@Service
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	PropertyRepository prepo;
	@Autowired
    private PropertyConverter propertyConverter;
	@Override
	public PropertyDTO addPropertys(Property property) {
		prepo.save(property);
		return propertyConverter.convertToPropertyDTO(property);
	}
	@Override
	public Property getPropertysDetail(int pid) {
		return prepo.findById(pid).orElseThrow( ()-> new IdNotFoundException("Property id is not found"));
	}
	@Override
	public Property updatePropertysDetail(Property property, int pid) {
		Property updateproperty = prepo.findById(pid).orElseThrow( ()-> new IdNotFoundException("Property id is not correct"));
		updateproperty.setPit(property.getPit());
		updateproperty.setPadd(property.getPadd());
		updateproperty.setPnofbathroom(property.getPnofbathroom());
		updateproperty.setPnofbedroom(property.getPnofbedroom());
		updateproperty.setPnofroom(property.getPnofroom());
		
		return updateproperty;
	}
	@Override
	public void deletePropertysDetail(int pid) {
		prepo.findById(pid).orElseThrow( ()-> new IdNotFoundException("PropertyDetail id is not correct"));
		prepo.deleteById(pid);
		
	}
	@Override
	public List<PropertyDTO> getAllPropertys() {
List<Property> property = prepo.findAll();
		
		List<PropertyDTO> dtoList = new ArrayList<>();
		for(Property a: property)
		{
			dtoList.add(propertyConverter.convertToPropertyDTO(a));
		}
		return dtoList;
	}
	
}
