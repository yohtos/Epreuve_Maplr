package com.maplr.testhockeygame.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import com.maplr.testhockeygame.entity.PlayerEntity;

public interface PlayerRepository extends JpaSpecificationExecutor<PlayerEntity>, JpaRepository<PlayerEntity, Integer> {
	
	PlayerEntity findByIdPlayer(@Param("idPlayer") Integer id);

}
