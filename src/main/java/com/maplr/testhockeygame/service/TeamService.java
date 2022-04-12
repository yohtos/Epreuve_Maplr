package com.maplr.testhockeygame.service;

import java.util.List;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.PlayerSaveDto;
import com.maplr.testhockeygame.dto.TeamDto;

public interface TeamService {

	public List<TeamDto> getAllTeam();
	
	public List<TeamDto> getAllTeamByYear(Long year);

	public PlayerSaveDto saveTeam(Long year, PlayerDto playerDto);
}
