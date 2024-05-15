package com.anudip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.Entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
