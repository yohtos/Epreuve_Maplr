package com.maplr.testhockeygame.dto;

import java.util.List;

public class TeamGetByYearDto {

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
	private List<PlayerWithoutTeamDto> players;

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

	public List<PlayerWithoutTeamDto> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerWithoutTeamDto> players) {
		this.players = players;
	}

	
}
