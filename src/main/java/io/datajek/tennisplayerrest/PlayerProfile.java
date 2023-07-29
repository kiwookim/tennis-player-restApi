package io.datajek.tennisplayerrest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String twitterHandle;

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

	@Override
	public String toString() {
		return "PlayerDetail [id=" + id + ", twitter=" + twitterHandle + "]";
	}

}
