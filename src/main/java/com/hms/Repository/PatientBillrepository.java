package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.PatientBill;

public interface PatientBillrepository extends JpaRepository<PatientBill, Integer>{

}
