package com.anudip.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.Entity.Nurse;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.NurseRepository;
import com.anudip.Service.NursesService;
@Service
public class NurseServiceImpl implements NursesService{
	@Autowired
	NurseRepository nrepo;

	@Override
	public Nurse addNurses(Nurse nurse) {
		return nrepo.save(nurse);
	}

	@Override
	public Nurse getNursesDetail(int nid) {
		return nrepo.findById(nid).orElseThrow(()-> new IdNotFoundException("Nurse id is incorrect"));
	}

	@Override
	public Nurse updateNursesDetail(Nurse nurse, int nid) {
		Nurse updatednurses = nrepo.findById(nid).orElseThrow(()-> new IdNotFoundException("Nurse id is incorrect"));

		//set new values
		updatednurses.setNid(nurse.getNid());
		updatednurses.setNfname(nurse.getNfname());
		updatednurses.setNlname(nurse.getNlname());
		updatednurses.setNphone(nurse.getNphone());
		updatednurses.setNemail(nurse.getNemail());
		nrepo.save(updatednurses);
		return updatednurses;
	}

	@Override
	public void deleteNursesDetail(int nid) {
		nrepo.findById(nid).orElseThrow(()-> new IdNotFoundException("Nurse id is incorrect"));
		nrepo.deleteById(nid);
		
	}
	
	@Override
	public List<Nurse> getAllNurse() {
		return nrepo.findAll();
	}
}
