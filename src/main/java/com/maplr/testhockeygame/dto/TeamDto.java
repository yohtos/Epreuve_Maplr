package com.maplr.testhockeygame.dto;

import java.util.List;

public class TeamDto {

	/**
	 * Id team
	 */
	private long id;
	
	/**
	 * Coach
	 */
	private String coach;
	
	/**
	 * year
	 */
	private long year;
	
	/**
	 * Players of the team
	 */
	private List<PlayerDto> players;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public List<PlayerDto> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDto> players) {
		this.players = players;
	}

	

		
	
	
}
