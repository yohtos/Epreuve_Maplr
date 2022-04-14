package com.maplr.testhockeygame.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.dto.TeamGetByYearDto;
import com.maplr.testhockeygame.entity.TeamEntity;

@Mapper(uses = {PlayerEntityDtoMapper.class})
public interface TeamEntityDtoMapper {

		@Named(value="teamEntityToTeamDto")
		@Mapping(source="idTeam", target="id")
		@Mapping(target="players",source="players", qualifiedByName="mappingPlayersEntityToDto")
		public TeamDto teamEntityToTeamDto(TeamEntity teamEntity);
		
		@Named(value="mappingTeamDtoToEntity")
		@Mapping(source="id", target="idTeam")
		@Mapping(target="players", source="players", qualifiedByName="mappingPlayersDtoToEntity")
		public TeamEntity teamDtoToEntity(TeamDto teamDto);
		
		@Named(value="mappingTeamEntityToTeamGetByYearDto")
		@Mapping(source="idTeam", target="id")
		@Mapping(target="players",source="players", qualifiedByName="mappingPlayersEntityToPlayerWithoutTeamDto")
		public TeamGetByYearDto teamEntityToTeamGetByYearDto(TeamEntity teamEntity);
}
