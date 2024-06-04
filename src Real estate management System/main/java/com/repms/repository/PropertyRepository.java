package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repms.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{

}
