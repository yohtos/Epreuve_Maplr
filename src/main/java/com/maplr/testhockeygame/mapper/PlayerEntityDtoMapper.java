package com.maplr.testhockeygame.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.PlayerWithoutTeamDto;
import com.maplr.testhockeygame.entity.PlayerEntity;

@Mapper
public interface PlayerEntityDtoMapper {
	
	@Named(value="mappingPlayersEntityToDto")
	@Mapping(target="id", source="idPlayer")
	@Mapping(target="players.teamDto", ignore = true)
	public PlayerDto playersEntityToDto(PlayerEntity playerEntity);
	
	@Named(value="mappingPlayersDtoToEntity")
	@Mapping(target="idPlayer", source="id")
	@Mapping(target="teamPlayer.players",source="teamDto.players", ignore = true)
	@Mapping(target="teamPlayer.idTeam",source="teamDto.id")
	public PlayerEntity playersDtoToEntity(PlayerDto playerDto);
	
	@Named(value="mappingPlayersEntityToPlayerWithoutTeamDto")
	public PlayerWithoutTeamDto playersToPlayerWithoutTeamDto(PlayerEntity playerEntity);
	
}
