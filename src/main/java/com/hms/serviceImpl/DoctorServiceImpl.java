package com.hms.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.Entity.Doctor;
import com.hms.Exception.IdNotFoundException;
import com.hms.Repository.DoctorRepository;
import com.hms.Service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
	DoctorRepository dorepo;
	
    @Override
	public Doctor addDoctors(Doctor doctor) {
		return dorepo.save(doctor);
	}
    
	@Override
	public Doctor getDoctorsDetail(int doid) {
		return dorepo.findById(doid).orElseThrow(()-> new IdNotFoundException("Doctor id is incorrect"));
	}

	@Override
	public Doctor updateDoctorsDetail(Doctor doctor, int doid) {
		Doctor updatedoctor = dorepo.findById(doid).orElseThrow(()-> new IdNotFoundException("Doctor id is incorrect"));

		//set new values
		updatedoctor.setDoid(doctor.getDoid());
		updatedoctor.setDfname(doctor.getDfname());
		updatedoctor.setDlname(doctor.getDlname());
		updatedoctor.setDemail(doctor.getDemail());
		updatedoctor.setDphone(doctor.getDphone ());
		updatedoctor.setDspecialization(doctor.getDspecialization());
		updatedoctor.setDvisitprice(doctor.getDvisitprice());
		updatedoctor.setDfollowupprice(doctor.getDfollowupprice());
		dorepo.save(updatedoctor);
		return updatedoctor;
	}
	

	@Override
	public void deleteDoctorsDetail(int did) {
		dorepo.findById(did).orElseThrow(()-> new IdNotFoundException("Doctor id is incorrect"));
		dorepo.deleteById(did);
		
	}
	
	@Override
	public List<Doctor> getAllDoctor() {
		return dorepo.findAll();
	}

	@Override
	public Doctor getDoctorByPhone(long dphone) {
		return dorepo.findDoctorByPhone(dphone);
	}

	@Override
	public List<Doctor> getDoctorByName(String dfname) {
		return dorepo.findDoctorByName(dfname);
	}

	@Override
	public List<Doctor> getDoctorspecialization(String dspecialization) {
		return dorepo.findDoctorspecialization(dspecialization);
	}

}
