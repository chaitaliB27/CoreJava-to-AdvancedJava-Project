package com.repms.service;

import java.util.List;

import com.repms.entity.Owner;
import com.repms.model.OwnerDTO;


public interface Ownerservice {
	OwnerDTO addOwner(Owner owner);
	
	
	Owner getOwnersDetail(int oid);
	

	Owner updateOwnersDetail(Owner owner, int oid);
	

	void deleteOwnersDetail(int oid);
	
	List<OwnerDTO> getAllOnwer();
}
