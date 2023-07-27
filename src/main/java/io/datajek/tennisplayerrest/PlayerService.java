package io.datajek.tennisplayerrest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
