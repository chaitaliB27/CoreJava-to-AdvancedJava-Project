package com.repms.serviceImpl;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.repms.entity.Owner;
import com.repms.exception.IdNotFoundException;
import com.repms.model.OwnerDTO;
import com.repms.repository.Ownerrepository;
import com.repms.service.Ownerservice;
import com.repms.util.OwnerConverter;
@Service
public class OwnerServiceImpl implements Ownerservice{
	@Autowired
	Ownerrepository orepo;
	@Autowired
    private OwnerConverter ownerConverter;
	@Override
	public OwnerDTO addOwner(Owner owner) {
		orepo.save(owner);
		return ownerConverter.convertToOwnerDTO(owner);
	}
	@Override
	public Owner getOwnersDetail(int oid) {
		return orepo.findById(oid).orElseThrow( ()-> new IdNotFoundException("Owner id is not found"));
	}
	@Override
	public Owner updateOwnersDetail(Owner owner, int oid) {
		
		Owner updateOwner = orepo.findById(oid).orElseThrow( ()-> new IdNotFoundException("Owner id is not correct"));
		updateOwner.setOit(owner.getOit());
		updateOwner.setOfname(owner.getOfname());
		updateOwner.setOlname(owner.getOlname());
		updateOwner.setOphone(owner.getOphone());
		updateOwner.setOemail(owner.getOemail());
		
		return updateOwner;
	}
	@Override
	public void deleteOwnersDetail(int oid) {
		orepo.findById(oid).orElseThrow( ()-> new IdNotFoundException("Owner id is not correct"));
		orepo.deleteById(oid);
		
	}
	@Override
	public List<OwnerDTO> getAllOnwer() {
List<Owner> owner = orepo.findAll();
		
		List<OwnerDTO> dtoList = new ArrayList<>();
		for(Owner a: owner)
		{
			dtoList.add(ownerConverter.convertToOwnerDTO(a));
		}
		return dtoList;
	}
	

}
