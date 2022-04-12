package com.maplr.testhockeygame.dto;

public class PlayerSaveDto {

	/**
	 * id player
	 */
	private Integer id;
	/**
	 * Number
	 */
	private long number;
	
	/**
	 * Name
	 */
	private String name;
	
	/**
	 * Last name
	 */
	private String lastName;
	
	/**
	 * Position
	 */
	private String position;
	
	/**
	 * Is captain
	 */
	private boolean isCaptain;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean getIsCaptain() {
		return isCaptain;
	}

	public void setIsCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}
	
	
}
