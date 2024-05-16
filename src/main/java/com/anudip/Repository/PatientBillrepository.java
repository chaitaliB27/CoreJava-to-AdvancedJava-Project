package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.Entity.PatientBill;

public interface PatientBillrepository extends JpaRepository<PatientBill, Integer>{

}
