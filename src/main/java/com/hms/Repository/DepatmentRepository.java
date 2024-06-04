package com.hms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hms.Entity.Department;



@Repository
public interface DepatmentRepository extends JpaRepository<Department, Integer>{

}
