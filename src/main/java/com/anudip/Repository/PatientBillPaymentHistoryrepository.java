package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.Entity.PatientBillPaymentHistory;
@Repository
public interface PatientBillPaymentHistoryrepository extends JpaRepository<PatientBillPaymentHistory, Integer>{

}
