package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDto;

public interface PlayerService {

	public PlayerDto updatePlayer(Integer id, PlayerDto playerDto);
}
