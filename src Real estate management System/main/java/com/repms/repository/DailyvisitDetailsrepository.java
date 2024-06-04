package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repms.entity.DailyvisitDetails;

@Repository
public interface DailyvisitDetailsrepository extends JpaRepository<DailyvisitDetails, Integer>{

}
