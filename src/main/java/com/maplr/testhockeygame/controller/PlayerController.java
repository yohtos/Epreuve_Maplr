package com.maplr.testhockeygame.controller;

import javax.ws.rs.core.MediaType;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

	private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	private static final String REST_API_PLAYER_CONTROLLER = "[REST API PlayerController]";
	
	private static final String REST_API_PLAYER_CONTROLLER_ERROR = "[ERROR REST API PlayerController]";
	
	@Autowired
	private PlayerService playerService;
	
	@PutMapping(value="/captain/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<PlayerDto> updatePlayer(@PathVariable("id") Integer id, @RequestBody PlayerDto playerDto) {
		logger.info(REST_API_PLAYER_CONTROLLER + "- updating player ...");
		PlayerDto playerDtoResult = new PlayerDto();
		try {
			if(id != null && playerDto != null) {
				playerDtoResult = playerService.updatePlayer(id, playerDto);
			}
		}catch (Exception e) {
			String message = REST_API_PLAYER_CONTROLLER_ERROR + e.getMessage();
			logger.error(message);
			throw new ServiceException(REST_API_PLAYER_CONTROLLER_ERROR);
		}
		return new ResponseEntity<>(playerDtoResult, HttpStatus.OK);
	}
}
