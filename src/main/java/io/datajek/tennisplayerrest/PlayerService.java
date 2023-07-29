package io.datajek.tennisplayerrest;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {
  @Autowired
  private PlayerRepository repo;

  //getAllPlayers
  public List<Player> getAllPlayers(){
    return repo.findAll();
  }

  //getPlayer By ID
  public Player getPlayer(int id){
    // So, in this approach of coding, we used Optional and avoided explicitly checking for null values.
    Optional<Player> tempPlayer = repo.findById(id);

    Player p = null;

    //if the Optional has a value, assign it to p
    if(tempPlayer.isPresent())
        p = tempPlayer.get();

    //if value is not found, throw a runtime exception
    else
        throw new RuntimeException("Player with id "+ id + " not found.");

    return p;
  }

  public Player addPlayer(Player p) {
		return repo.save(p);
	}

  public Player updatePlayer(int id, Player p) {
    Optional<Player> playerOptional = repo.findById(id);
    if (playerOptional.isPresent()) {
      Player specificPlayer = playerOptional.get();

      specificPlayer.setName(p.getName());
      specificPlayer.setNationality(p.getNationality());
      specificPlayer.setBirthDate(p.getBirthDate());
      specificPlayer.setTitles(p.getTitles());
      return repo.save(specificPlayer);
    } else {
      throw new NoSuchElementException("Player with ID " + id + " not found.");
    }

  }

  public Player patchPlayer(int id, Map<String, Object> patchData){
    Optional<Player> specificPlayer = repo.findById(id);
    if(specificPlayer.isPresent()){
      patchData.forEach((key,value)->{
        Field field = ReflectionUtils.findField(Player.class,key);
        // make the filed accessible for edit
        ReflectionUtils.makeAccessible(field);
        // set field
        ReflectionUtils.setField(field, specificPlayer.get(), value);

      });
    }
    return repo.save(specificPlayer.get());
  }

  //single column update
  //transactional to have the data be commited or rolled back in case of failure
  @Transactional
  public void updateTitles(int id, int titles) {
    repo.updateTitles(id,titles);
  }

}
