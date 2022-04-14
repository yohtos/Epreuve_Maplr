package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.PlayerWithoutTeamDto;
import com.maplr.testhockeygame.dto.TeamGetByYearDto;

public interface TeamService {
	
	public TeamGetByYearDto getTeamByYear(Long year);

	public PlayerWithoutTeamDto saveTeam(Long year, PlayerDto playerDto);
}
