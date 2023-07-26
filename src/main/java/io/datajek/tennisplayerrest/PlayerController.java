package io.datajek.tennisplayerrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
  @Autowired
  PlayerService service;

  @GetMapping("/welcome")
  public String welcome() {
    return "Wecome to Tennis Players REST API";
  }

  @GetMapping("/players")
  public List<Player> getAllPlayers(){
    return service.getAllPlayers();
  }

}
