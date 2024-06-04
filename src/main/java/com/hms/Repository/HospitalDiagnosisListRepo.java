package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.Entity.HospitalDiagnosisList;
@Repository
public interface HospitalDiagnosisListRepo extends JpaRepository<HospitalDiagnosisList, Integer>{

}
