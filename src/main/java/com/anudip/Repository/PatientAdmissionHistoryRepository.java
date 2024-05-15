package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.Entity.PatientAdmissionHistory;
@Repository
public interface PatientAdmissionHistoryRepository extends JpaRepository<PatientAdmissionHistory, Integer>{

}
