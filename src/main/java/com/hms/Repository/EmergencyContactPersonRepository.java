package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.EmergencyContactPerson;

public interface EmergencyContactPersonRepository extends JpaRepository<EmergencyContactPerson, Integer>{

}
