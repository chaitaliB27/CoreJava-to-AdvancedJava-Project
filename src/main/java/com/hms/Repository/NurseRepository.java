package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Integer>{

}
