package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.HealthInsurance;

public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance, Integer>{

}
