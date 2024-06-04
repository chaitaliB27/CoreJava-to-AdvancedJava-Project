package com.repms.service;

import java.util.List;

import com.repms.entity.RentDeatils;
import com.repms.model.RentDetailsDTO;


public interface RentDeatilsServices {
	RentDetailsDTO addRentDetails(RentDeatils rentDeatils);
	
	RentDeatils getRentsDetail(int rit);
		
	RentDeatils updateRentsDetail(RentDeatils rent, int rit);
		
	void deleteRentsDetail(int rit);
		
	List<RentDetailsDTO> getAllRentDetails();
}
