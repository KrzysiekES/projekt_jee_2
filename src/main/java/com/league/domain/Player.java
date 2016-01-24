package com.league.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Player")
@NamedQueries({ 
	@NamedQuery(name = "player.getAll", query = "Select p from Player p"),
	@NamedQuery(name = "player.getByIdClub", query = "Select p from Player p where p.club = :idClub")
})

public class Player {

	private Long idPlayer;
	private String firstName;
	private String lastName;
	private int shirtNumber;
	private String position;
    private Date bornDate;
  
  
    private Club club;
  
    //Konstruktory
	 public Player() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
  
    public String getFirstName(){
        return firstName; 
    }
    public void setFirstName(String firstName){
      this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName; 
    }
    public void setLastName(String lastName){
      this.lastName = lastName;
    }
	
    public int getShirtNumber(){
        return shirtNumber; 
    }
    public void setShirtNumber(int shirtNumber){
      this.shirtNumber = shirtNumber;
    }
  
    public String getPosition(){
        return position; 
    }
    public void setPosition(String position){
      this.position = position;
    }

  	@Temporal(TemporalType.DATE)
	public Date getBornDate() {
		return bornDate;
	}
  
    public void setBornDate(Date bornDate){
        this.bornDate = bornDate; 
    }

	@ManyToOne
	@JoinColumn(name = "idClub")
	public Club getClub() {
	    return club;
	}
  
	public void setClub(Club club) {
      this.club = club;
    }
	

}
