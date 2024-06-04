package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
