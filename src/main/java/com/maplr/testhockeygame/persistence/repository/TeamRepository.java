package com.maplr.testhockeygame.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maplr.testhockeygame.entity.TeamEntity;

public interface TeamRepository extends JpaSpecificationExecutor<TeamEntity>, JpaRepository<TeamEntity, Integer> {
	
	TeamEntity findByYear(Long year);
}
