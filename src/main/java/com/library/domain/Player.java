package com.library.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "player.all", query = "Select p from Player "),
        @NamedQuery(name = "book.byTitle", query = "Select p from Player p where p.position = :position")
})
@Table(name = "Player")
@XmlRootElement
public class Player {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerId;
    
    
	//private int clubId;
    @Column(nullable = false)
	private String firstName = "unknown";
    @Column(nullable = false)
	private String lastName = "unknown";
    @Column(nullable = false)
	private String position = "unknown";
    @Column(nullable = false)
	private int number = 0;
	
    
	
	public Player() {
		super();
	}
	//Konstruktor
	public Player(long playerId, int clubId, String firstName, String lastName, String position, int number) {
		super();
		this.setPlayerId(playerId);
		this.setClubId(clubId);
		this.firstName = firstName;
		this.setLastName(lastName);
		this.setPosition(position);
		this.setNumber(number);
	}
	//Setters & Getters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	/*
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}*/

}