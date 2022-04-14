package com.maplr.testhockeygame.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = PlayerEntity.SEQUENCE_GENERATOR, sequenceName = PlayerEntity.SEQUENCE_NAME, allocationSize = 1)
@Table(name="PLAYER")
public class PlayerEntity implements Serializable {

	/**
	 * Serial version UID autogenerated
	 */
	private static final long serialVersionUID = -6795884084059182284L;
	public static final String SEQUENCE_GENERATOR = "SEQ_PLAYER";
	public static final String SEQUENCE_NAME = "S_PLAYER_ID";

	/**
	 * Id player
	 */
	@Id
	@GeneratedValue(generator = SEQUENCE_GENERATOR)
	@Column(name="ID_PLAYER", nullable=false)
	private Integer idPlayer;
	
	/**
	 * Number
	 */
	@Column(name="NUMBER", nullable=false)
	private long number;
	
	/**
	 * Name
	 */
	@Column(name="NAME", nullable=false)
	private String name;
	
	/**
	 * Last name
	 */
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	/**
	 * Position
	 */
	@Column(name="POSITION", nullable=false)
	private String position;
	
	/**
	 * Is captain or not: we choose captain and not captain to avoid getter setter problem
	 */
	@Column(name="IS_CAPTAIN", nullable=false)
	private boolean isCaptain;

	/**
	 * la team à laquelle elle est rattachée
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_TEAM", nullable=true)
	private TeamEntity teamPlayer;

	public Integer getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
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

	public TeamEntity getTeamPlayer() {
		return teamPlayer;
	}

	public void setTeamPlayer(TeamEntity teamPlayer) {
		this.teamPlayer = teamPlayer;
	}


	

	
	
	
}
