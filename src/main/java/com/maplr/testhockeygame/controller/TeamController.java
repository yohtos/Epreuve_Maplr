package com.maplr.testhockeygame.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.PlayerSaveDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	private static final String REST_API_TEAM_CONTROLLER = "[REST API TeamController]";
	
	private static final String REST_API_TEAM_CONTROLLER_ERROR = "[ERROR REST API TeamController]";

	
	@Autowired
	private TeamService teamService;

	@GetMapping("/")
	public List<TeamDto> getAllTeam() {
		return teamService.getAllTeam();
	}
	
	/**
	 * get all team by year
	 * 
	 * @param year: year's team
	 * @return list of teamDto
	 */
	@GetMapping(value="/{year}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<TeamDto>> getAllTeamByYear(@PathVariable("year") Long year) {
		logger.info(REST_API_TEAM_CONTROLLER + "- getAllTeamByYear ...");
		List<TeamDto> teamDtoList = new ArrayList<>();
		try {
			if(year != null) {
				teamDtoList = teamService.getAllTeamByYear(year);
			}
		}catch (Exception e) {
			String message = REST_API_TEAM_CONTROLLER_ERROR + e.getMessage();
			logger.error(message);
			throw new ServiceException(REST_API_TEAM_CONTROLLER_ERROR);
		}
		return new ResponseEntity<>(teamDtoList, HttpStatus.OK);
	}
	
	@PostMapping(value="/{year}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<PlayerSaveDto> saveTeam(@PathVariable("year") Long year, @RequestBody PlayerDto playerDto) {
		logger.info(REST_API_TEAM_CONTROLLER + "- save TeamDto ...");
		PlayerSaveDto playerDtoResult = new PlayerSaveDto();
		try {
			if(year != null && playerDto != null) {
				playerDtoResult = teamService.saveTeam(year, playerDto);
			}
		}catch (Exception e) {
			String message = REST_API_TEAM_CONTROLLER_ERROR + e.getMessage();
			logger.error(message);
			throw new ServiceException(REST_API_TEAM_CONTROLLER_ERROR);
		}
		return new ResponseEntity<>(playerDtoResult, HttpStatus.OK);
	}
		
	
}
