package com.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name="player")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerId;
	@Column(nullable=false,name="name")
	private String playerName;
	// private String teamName; // will be replacing this as Team object to create relationship between team and player
	
	/* till 25.07 where one to one mapping Player -> team
	 * //@OneToOne //private Team team;
	 * 
	 * 	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
		public Player(String playerName, Team team, int age) {
		super();
		this.playerName = playerName;
		this.team = team;
		this.age = age;
	}

	public Player(int playerId, String playerName, Team team, int age) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.team = team;
		this.age = age;
	}
	 */	
	@OneToMany
	List<Team> teamList = new ArrayList<>();
	
	public List<Team> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	private int age;
	public Player() {
		
	}

	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", teamDetails=" + teamList + ", age=" + age
				+ "]";
	}
	/*
	 * @Override public String toString() { return "Player [playerId=" + playerId +
	 * ", playerName=" + playerName + ", teamName=" + teamName + ", age=" + age +
	 * "]"; }
	 */
	/*
	 * public String getTeamName() { return teamName; }
	 */
	/*
	 * public void setTeamName(String teamName) { this.teamName = teamName; }
	 */
}
