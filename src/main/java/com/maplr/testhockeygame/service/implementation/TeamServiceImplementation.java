package com.maplr.testhockeygame.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.PlayerSaveDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.entity.TeamEntity;
import com.maplr.testhockeygame.mapper.PlayerEntityDtoMapper;
import com.maplr.testhockeygame.mapper.TeamEntityDtoMapper;
import com.maplr.testhockeygame.persistence.repository.PlayerRepository;
import com.maplr.testhockeygame.persistence.repository.TeamRepository;
import com.maplr.testhockeygame.service.TeamService;

@Service("TeamService")
public class TeamServiceImplementation implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	private TeamEntityDtoMapper teamMapper;
	private PlayerEntityDtoMapper playerMapper;
	
	@PostConstruct
	private void mapStructMapper() {
		teamMapper = Mappers.getMapper(TeamEntityDtoMapper.class);
		playerMapper = Mappers.getMapper(PlayerEntityDtoMapper.class);
	}
	
	@Override
	public List<TeamDto> getAllTeam() {
		List<TeamEntity> listTeamEntities = teamRepository.findAll();
		
		 return listTeamEntities.stream().map(teamEntity -> teamMapper.teamEntityToTeamDto(teamEntity)).collect(Collectors.toList());
	}
	
	@Override
	public List<TeamDto> getAllTeamByYear(Long year) {
		List<TeamEntity> listTeamEntities = teamRepository.findAllByYear(year);
		
		 return listTeamEntities.stream().map(teamEntity -> teamMapper.teamEntityToTeamDto(teamEntity)).collect(Collectors.toList());
	}

	
	@Override
	public PlayerSaveDto saveTeam(Long year, PlayerDto playerDto) {
		List<TeamEntity> listTeamEntities = teamRepository.findAllByYear(year);
		TeamDto teamDto = listTeamEntities != null && !listTeamEntities.isEmpty() ? teamMapper.teamEntityToTeamDto(listTeamEntities.get(0)): new TeamDto();
		playerDto.setTeamDto(teamDto);
		PlayerEntity playerEntity = playerMapper.playersDtoToEntity(playerDto);
		playerRepository.save(playerEntity);
		return playerMapper.playersWithoutTeamEntityToDto(playerEntity);
	}

	
}
