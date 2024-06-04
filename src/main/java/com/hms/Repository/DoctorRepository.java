package com.hms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.Entity.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	@Query("Select d from Doctor d where d.dphone=?1")
	Doctor findDoctorByPhone(long dphone);
	
	@Query("Select d1 from Doctor d1 where d1.dfname=?1")
	List<Doctor> findDoctorByName(String dfname);
	
	@Query("Select d2 from Doctor d2 where d2.dspecialization like ?1% order by dfname")
	List<Doctor> findDoctorspecialization(String dspecialization);
}
