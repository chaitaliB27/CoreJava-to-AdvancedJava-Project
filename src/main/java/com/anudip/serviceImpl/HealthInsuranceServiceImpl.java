package com.anudip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anudip.Entity.HealthInsurance;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.HealthInsuranceRepository;
import com.anudip.Service.HealthInsuranceService;
@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService{
    @Autowired
	HealthInsuranceRepository hirepo;
	@Override
	public HealthInsurance addHealthInsurances(HealthInsurance healthInsurance) {
		return hirepo.save(healthInsurance);
	}

	@Override
	public HealthInsurance getHealthInsurancesDetail(int hcid) {
		return hirepo.findById(hcid).orElseThrow(()-> new IdNotFoundException("HealthInsurance id is incorrect"));
	}

	@Override
	public HealthInsurance updateHealthInsurancesDetail(HealthInsurance healthInsurance, int hcid) {
		HealthInsurance updatedHealthInsurance = hirepo.findById(hcid).orElseThrow(()-> new IdNotFoundException("HealthInsurance id is incorrect"));

		//set new values
		updatedHealthInsurance.setHcid(healthInsurance.getHcid());
		updatedHealthInsurance.setcName(healthInsurance.getcName());
		updatedHealthInsurance.setCphone(healthInsurance.getCphone());
		updatedHealthInsurance.setCemail(healthInsurance.getCemail());
		updatedHealthInsurance.setCadd(healthInsurance.getCadd());
		
		hirepo.save(updatedHealthInsurance);
		return updatedHealthInsurance;
	}

	@Override
	public void deleteHealthInsurancesDetail(int hcid) {
		hirepo.findById(hcid).orElseThrow(()-> new IdNotFoundException("HealthInsurance id is incorrect"));
		hirepo.deleteById(hcid);
		
	}

}
