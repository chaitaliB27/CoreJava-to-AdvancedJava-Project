package com.anudip.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anudip.Entity.HospitalDiagnosisList;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.HospitalDiagnosisListRepo;
import com.anudip.Service.HospitalDiagnosisListService;


@Service
public class HospitalDiagnosisListServiceImpl implements HospitalDiagnosisListService{
	 @Autowired
		HospitalDiagnosisListRepo hdlrepo;
		@Override
		public HospitalDiagnosisList addHospitalDiagnosisListService(HospitalDiagnosisList hospitalDiagnosisList) {
			return hdlrepo.save(hospitalDiagnosisList);
		}

		@Override
		public HospitalDiagnosisList getHospitalDiagnosisListService(int hdid) {
			return hdlrepo.findById(hdid).orElseThrow(()-> new IdNotFoundException("HealthInsurance id is incorrect"));
		}

		@Override
		public HospitalDiagnosisList updateHospitalDiagnosisListServicesDetail(HospitalDiagnosisList hospitalDiagnosisList, int hdid) {
			HospitalDiagnosisList updatedHospitalDiagnosisList = hdlrepo.findById(hdid).orElseThrow(()-> new IdNotFoundException("HealthInsurance id is incorrect"));

			//set new values
			updatedHospitalDiagnosisList.setHdid(hospitalDiagnosisList.getHdid());
			updatedHospitalDiagnosisList.setLab_Add(hospitalDiagnosisList.getLab_Add());
			updatedHospitalDiagnosisList.setLab_email(hospitalDiagnosisList.getLab_email());
			updatedHospitalDiagnosisList.setLab_phoneOrMobile(hospitalDiagnosisList.getLab_phoneOrMobile());
			updatedHospitalDiagnosisList.setDiagnosisTest_price(hospitalDiagnosisList.getDiagnosisTest_price());
			
			hdlrepo.save(updatedHospitalDiagnosisList);
			return updatedHospitalDiagnosisList;
		}

		@Override
		public void deleteHospitalDiagnosisListServicesDetail(int hdid) {
			hdlrepo.findById(hdid).orElseThrow(()-> new IdNotFoundException("HealthInsurance id is incorrect"));
			hdlrepo.deleteById(hdid);
			
		}
}
