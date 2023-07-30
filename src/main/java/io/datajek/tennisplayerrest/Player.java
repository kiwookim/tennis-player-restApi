package io.datajek.tennisplayerrest;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  // private String nationality;

  // @JsonFormat(pattern = "dd-MM-yyyy")
  // private Date birthDate;

  // private int titles;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	private PlayerProfile playerProfile;


  //constructors
  Player(){};
  Player(String name,PlayerProfile playerProfile){
    super();
		this.name = name;
		this.playerProfile = playerProfile;
		// this.nationality = nationality;
		// this.birthDate = birthDate;
		// this.titles = titles;
  }

  //getter and setters
  public int getId() {
    return id;
  }
  public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public String getNationality() {
	// 	return nationality;
	// }

	// public void setNationality(String nationality) {
	// 	this.nationality = nationality;
	// }

	// public Date getBirthDate() {
	// 	return birthDate;
	// }

	// public void setBirthDate(Date birthDate) {
	// 	this.birthDate = birthDate;
	// }

	// public int getTitles() {
	// 	return titles;
	// }

	// public void setTitles(int titles) {
	// 	this.titles = titles;
	// }
	public PlayerProfile getPlayerProfile() {
		return playerProfile;
	}

	public void setPlayerProfile(PlayerProfile playerProfile) {
		this.playerProfile = playerProfile;
	}

	@Override
	public String toString() {
		return "\nPlayer [id= " + id + ", name= " + name  + ", playerProfile=" + playerProfile + "]";
	}

}
