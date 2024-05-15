package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.Entity.PatientDiagnosisHistory;

public interface PatientDiagnosisHistoryRepository extends JpaRepository<PatientDiagnosisHistory, Integer>{

}
