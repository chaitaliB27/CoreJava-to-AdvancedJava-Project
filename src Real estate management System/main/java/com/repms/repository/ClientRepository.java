package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repms.entity.ClientRes;

@Repository
public interface ClientRepository extends JpaRepository<ClientRes, Integer>{

}
