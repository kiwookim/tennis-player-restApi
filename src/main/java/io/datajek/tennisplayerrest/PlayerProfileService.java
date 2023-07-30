package io.datajek.tennisplayerrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileService {
  @Autowired
  PlayerProfileRepository profile_repo;

  public List<PlayerProfile> allPlayerProfiles() {
		return profile_repo.findAll();
	}

	public PlayerProfile getPlayerProfile(int id){
		return profile_repo.findById(id).get();
	}

	public PlayerProfile addPlayerProfile(PlayerProfile profile) {
		profile.setId(0);
		return profile_repo.save(profile);
	}
	// removes the link between the PlayerProfile and Player object by manually setting the references to null before deleting from the database.
	public void deletePlayerProfile(int id) {
		PlayerProfile tempPlayerProfile = profile_repo.findById(id).get();
		tempPlayerProfile.getPlayer().setPlayerProfile(null);
		tempPlayerProfile.setPlayer(null);
		profile_repo.save(tempPlayerProfile);
		profile_repo.delete(tempPlayerProfile);
	}
}
