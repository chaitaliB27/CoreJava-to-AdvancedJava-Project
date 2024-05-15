package com.anudip.Service;

import java.util.List;

import com.anudip.Entity.Nurse;


public interface NursesService {
	//method for saving Students details in db table
		Nurse addNurses(Nurse nurse);
			
			//method to fetch Students detail based on sid from db table
		Nurse getNursesDetail(int nid);
			
			//method to modify Students detail based on sid from db table
		Nurse updateNursesDetail(Nurse nurse, int nid);
			
			//method to remove Students detail based on sid from db table
			void deleteNursesDetail(int nid);
			
			List<Nurse> getAllNurse();
}
