package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.Entity.HospitalDiagnosisList;
@Repository
public interface HospitalDiagnosisListRepo extends JpaRepository<HospitalDiagnosisList, Integer>{

}
