package main.java.com.example.projekt_jee_liga.domain;

public class Club {
	private int clubId=1;
	private String clubName = "";
	private String clubCity = "";
	private String clubMenager = "";

	public Club() {
		super();
	}
	//Konstruktor
	public Club(int clubId, String clubName, String clubCity, String clubMenager) {
		super();
		this.setClubId(clubId);
		this.setClubName(clubName);
		this.setClubCity(clubCity);
		this.setClubMenager(clubMenager);

	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubCity() {
		return clubCity;
	}
	public void setClubCity(String clubCity) {
		this.clubCity = clubCity;
	}
	public String getClubMenager() {
		return clubMenager;
	}
	public void setClubMenager(String clubMenager) {
		this.clubMenager = clubMenager;
	}


}