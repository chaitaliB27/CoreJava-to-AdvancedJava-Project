package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repms.entity.Owner;
@Repository
public interface Ownerrepository extends JpaRepository<Owner, Integer>{

}
