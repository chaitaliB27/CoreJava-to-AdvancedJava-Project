package com.repms.service;

import java.util.List;

import com.repms.entity.DailyvisitDetails;
import com.repms.model.DailyVisitDetailsDTO;
public interface DailyvisitDetailsservice {
	DailyVisitDetailsDTO addDailyvisitDetails( DailyvisitDetails dailyvisitDetails);
	

	DailyvisitDetails getDailyvisitDetailssDetail(int dvit);
	
	
	DailyvisitDetails updateDailyvisitDetails(DailyvisitDetails dailyvisitDetails, int dvit);
	
	
	void deleteDailyvisitDetails(int dvit);
	
	List<DailyVisitDetailsDTO> getAllDailyvisitDetails();
}
