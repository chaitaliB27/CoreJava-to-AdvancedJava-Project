package com.hms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hms.Entity.EmergencyContactPerson;
import com.hms.Exception.IdNotFoundException;
import com.hms.Repository.EmergencyContactPersonRepository;
import com.hms.Service.EmergencyContactPersonService;
@Service
public class EmergencyContactPersonServiceImpl implements EmergencyContactPersonService{
	 @Autowired
		EmergencyContactPersonRepository ecprepo;
		@Override
		public EmergencyContactPerson addEmergencyContactPersons(EmergencyContactPerson emergencyContactPerson) {
			return ecprepo.save(emergencyContactPerson);
		}

		@Override
		public EmergencyContactPerson getEmergencyContactPersonsDetail(int epid) {
			return ecprepo.findById(epid).orElseThrow(()-> new IdNotFoundException("emergencyContactPerson id is incorrect"));
		}

		@Override
		public EmergencyContactPerson updateEmergencyContactPersonsDetail(EmergencyContactPerson emergencyContactPerson, int epid) {
			EmergencyContactPerson updateEmergencyContactPerson = ecprepo.findById(epid).orElseThrow(()-> new IdNotFoundException("emergencyContactPerson id is incorrect"));

			//set new values
			updateEmergencyContactPerson.setEpid(emergencyContactPerson.getEpid());
			updateEmergencyContactPerson.setEpfname(emergencyContactPerson.getEpfname());
			updateEmergencyContactPerson.setEplname(emergencyContactPerson.getEplname());
			updateEmergencyContactPerson.setEpphone(emergencyContactPerson.getEpphone());
			
			ecprepo.save(updateEmergencyContactPerson);
			return updateEmergencyContactPerson;
		}

		@Override
		public void deleteEmergencyContactPersonsDetail(int epid) {
			ecprepo.findById(epid).orElseThrow(()-> new IdNotFoundException("emergencyContactPerson id is incorrect"));
			ecprepo.deleteById(epid);
			
		}

}
