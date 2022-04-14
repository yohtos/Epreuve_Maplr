package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.PlayerSaveDto;
import com.maplr.testhockeygame.dto.TeamDto;

public interface TeamService {
	
	public TeamDto getTeamByYear(Long year);

	public PlayerSaveDto saveTeam(Long year, PlayerDto playerDto);
}
