package io.datajek.tennisplayerrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @GetMapping("/players/{id}")
  public Player getPlayer(@PathVariable int id) {
    return service.getPlayer(id);
  }

  @PostMapping("/players")
  public Player addPlayer(@RequestBody Player p){
    // p.setId(0);
    return service.addPlayer(p);
  }

  @PutMapping("/players/{id}")
  public Player updatePlayer(@PathVariable int id ,@RequestBody Player p){
    return service.updatePlayer(id,p);
  }
}
