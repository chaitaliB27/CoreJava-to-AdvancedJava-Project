package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repms.entity.SaleImformation;

@Repository
public interface SaleImformationrepository extends JpaRepository<SaleImformation, Integer>{

}
