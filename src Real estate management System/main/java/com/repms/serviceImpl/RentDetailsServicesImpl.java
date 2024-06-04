package com.repms.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repms.entity.RentDeatils;
import com.repms.exception.IdNotFoundException;
import com.repms.model.RentDetailsDTO;
import com.repms.repository.RentDetailsRepository;
import com.repms.service.RentDeatilsServices;
import com.repms.util.RentDetailsConverter;
@Service
public class RentDetailsServicesImpl implements RentDeatilsServices{

	@Autowired
	RentDetailsRepository rentDetailsRepository;
	
	@Autowired
	RentDetailsConverter rentDetailsConverter;
	@Override
	public RentDetailsDTO addRentDetails(RentDeatils rentDeatils) {
		rentDetailsRepository.save(rentDeatils);
		return rentDetailsConverter.convertToRentDetailsDTO(rentDeatils);
	}

	@Override
	public RentDeatils getRentsDetail(int rit) {
		return rentDetailsRepository.findById(rit).orElseThrow( ()-> new IdNotFoundException("RentDetail id is not found"));
	}

	@Override
	public RentDeatils updateRentsDetail(RentDeatils rent, int rit) {
		RentDeatils updateRentDetail = rentDetailsRepository.findById(rit).orElseThrow( ()-> new IdNotFoundException("RentDetail id is not correct"));
		updateRentDetail.setRit(rent.getRit());
		updateRentDetail.setRstartDate(rent.getRstartDate());
		updateRentDetail.setRendDate(rent.getRendDate());
		updateRentDetail.setRentalAgreementContent(rent.getRentalAgreementContent());
		updateRentDetail.setRentPrice(rent.getRentPrice());
		rentDetailsRepository.save(updateRentDetail);
		
		return updateRentDetail;
	}

	@Override
	public void deleteRentsDetail(int rit) {
		rentDetailsRepository.findById(rit).orElseThrow( ()-> new IdNotFoundException("RentDetails id is not correct"));
		rentDetailsRepository.deleteById(rit);
		
	}

	@Override
	public List<RentDetailsDTO> getAllRentDetails() {
        List<RentDeatils> rentDeatils = rentDetailsRepository.findAll();
		
		List<RentDetailsDTO> dtoList = new ArrayList<>();
		for(RentDeatils a: rentDeatils)
		{
			dtoList.add(rentDetailsConverter.convertToRentDetailsDTO(a));
		}
		return dtoList;
	}

}
