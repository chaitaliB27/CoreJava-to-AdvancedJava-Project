package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.PatientDiagnosisHistory;

public interface PatientDiagnosisHistoryRepository extends JpaRepository<PatientDiagnosisHistory, Integer>{

}
