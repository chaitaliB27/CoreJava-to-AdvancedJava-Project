package com.repms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.repms.entity.Agent;
@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer>{

}
