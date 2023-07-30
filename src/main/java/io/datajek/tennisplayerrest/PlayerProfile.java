package io.datajek.tennisplayerrest;


import jakarta.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")

public class PlayerProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String twitterHandle;

  @OneToOne(mappedBy = "playerProfile", cascade= CascadeType.ALL)
	private Player player;

  //constructors,getters,setters
  public PlayerProfile() {
	}

	public PlayerProfile(String twitter) {
		super();
		this.twitterHandle = twitter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTwitter() {
		return twitterHandle;
	}

	public void setTwitter(String twitter) {
		this.twitterHandle = twitter;
	}

	//getter and setter for player field


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerDetail [id=" + id + ", twitter=" + twitterHandle + ", player=" + player + "]";
	}

}
