package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repms.entity.RentDeatils;
@ Repository
public interface RentDetailsRepository extends JpaRepository<RentDeatils, Integer> {

}
