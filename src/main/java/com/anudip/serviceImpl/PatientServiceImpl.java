package com.anudip.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.Entity.Patient;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.PatientRepository;
import com.anudip.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
	PatientRepository prepo;
	@Override
	public Patient addPatients(Patient patient) {
		return prepo.save(patient);
	}

	@Override
	public Patient getPatientsDetail(int pid) {
		return prepo.findById(pid).orElseThrow(()-> new IdNotFoundException("patient id is incorrect"));
	}

	@Override
	public Patient updatePatientsDetail(Patient patient, int pid) {
		Patient updatepatient = prepo.findById(pid).orElseThrow(()-> new IdNotFoundException("Patient id is incorrect"));

		//set new values
		updatepatient.setPid(patient.getPid());
		updatepatient.setPemail(patient.getPemail());
		updatepatient.setPlname(patient.getPlname());
		updatepatient.setPemail(patient.getPemail());
		updatepatient.setPphone(patient.getPphone ());
		updatepatient.setAge(patient.getAge());
		updatepatient.setSaddr(patient.getSaddr());
		updatepatient.setDateofbirth(patient.getDateofbirth());
		updatepatient.setEmergencyContactPerson(patient.getEmergencyContactPerson());
		prepo.save(updatepatient);
		return updatepatient;
	}

	@Override
	public void deletePatientsDetail(int pid) {
		prepo.findById(pid).orElseThrow(()-> new IdNotFoundException("Patient id is incorrect"));
		prepo.deleteById(pid);
		
	}
	
	@Override
	public List<Patient> getAllPatient() {
		return prepo.findAll();
	}

}
