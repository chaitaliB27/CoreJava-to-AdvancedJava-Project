package com.repms.serviceImpl;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repms.entity.DailyvisitDetails;
import com.repms.exception.IdNotFoundException;
import com.repms.model.DailyVisitDetailsDTO;
import com.repms.repository.DailyvisitDetailsrepository;
import com.repms.service.DailyvisitDetailsservice;
import com.repms.util.DailyvisitDetailsConverter;
@Service
public class DailyvisitDetailsservicempl implements DailyvisitDetailsservice{
    @Autowired
	DailyvisitDetailsrepository drepo;
    @Autowired
    private DailyvisitDetailsConverter dailyvisitDetailsConverter;
	@Override
	public DailyVisitDetailsDTO addDailyvisitDetails(DailyvisitDetails dailyvisitDetails) {
		drepo.save(dailyvisitDetails);
		return dailyvisitDetailsConverter.convertToDailyvisitDetailsDTO(dailyvisitDetails);
	}

	@Override
	public DailyvisitDetails getDailyvisitDetailssDetail(int dvit) {
		return drepo.findById(dvit).orElseThrow( ()-> new IdNotFoundException("DaliyVisit Coustomer id is not found"));
	}

	@Override
	public DailyvisitDetails updateDailyvisitDetails(DailyvisitDetails dailyvisitDetails, int dvit) {
		DailyvisitDetails updateDailyvisitDetails = drepo.findById(dvit).orElseThrow( ()-> new IdNotFoundException("DaliyVisit Coustomer id is not correct"));
		updateDailyvisitDetails.setDvit(dailyvisitDetails.getDvit());
		updateDailyvisitDetails.setCfname(dailyvisitDetails.getCfname());
		updateDailyvisitDetails.setClname(dailyvisitDetails.getClname());
		updateDailyvisitDetails.setVisitDate(dailyvisitDetails.getVisitDate());
		updateDailyvisitDetails.setClientWish(dailyvisitDetails.getClientWish());
		drepo.save(updateDailyvisitDetails);
		
		return updateDailyvisitDetails;
	}

	@Override
	public void deleteDailyvisitDetails(int dvit) {
		drepo.findById(dvit).orElseThrow( ()-> new IdNotFoundException("DailyDetail id is not correct"));
		drepo.deleteById(dvit);
		
	}

	@Override
	public List<DailyVisitDetailsDTO>getAllDailyvisitDetails() {
List<DailyvisitDetails> dailyvisitDetails = drepo.findAll();
		
		List<DailyVisitDetailsDTO> dtoList = new ArrayList<>();
		for(DailyvisitDetails a: dailyvisitDetails)
		{
			dtoList.add(dailyvisitDetailsConverter.convertToDailyvisitDetailsDTO(a));
		}
		return dtoList;
	}
	
	

}
