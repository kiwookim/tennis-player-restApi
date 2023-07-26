package io.datajek.tennisplayerrest;

import java.util.List;

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
}
