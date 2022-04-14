package com.maplr.testhockeygame.service.implementation;

import javax.annotation.PostConstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.mapper.PlayerEntityDtoMapper;
import com.maplr.testhockeygame.persistence.repository.PlayerRepository;
import com.maplr.testhockeygame.service.PlayerService;

@Service("PlayerService")
public class PlayerServiceImplementation implements PlayerService {

	@Autowired
	private PlayerRepository repository;
	
	private PlayerEntityDtoMapper mapper;
	
	@PostConstruct
	private void mapStructMapper() {
		mapper = Mappers.getMapper(PlayerEntityDtoMapper.class);
	}
	
	public PlayerDto updatePlayer(Integer id) {
		PlayerEntity playerEntity = repository.findByIdPlayer(id);
		playerEntity.setIsCaptain(true);
		repository.save(playerEntity);
		return mapper.playersEntityToDto(playerEntity);
	}
}
