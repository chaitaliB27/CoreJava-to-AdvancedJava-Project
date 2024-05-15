package com.anudip.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.anudip.Entity.Department;



@Repository
public interface DepatmentRepository extends JpaRepository<Department, Integer>{

}
