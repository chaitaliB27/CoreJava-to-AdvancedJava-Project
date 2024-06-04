package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.Entity.PatientHistory;
@Repository
public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Integer> {

}
