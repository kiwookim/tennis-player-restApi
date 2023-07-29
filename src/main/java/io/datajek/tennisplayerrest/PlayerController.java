package io.datajek.tennisplayerrest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
  @Autowired
  PlayerService service;

  @Autowired
  PlayerProfileService profileService;

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
    p.setId(0);
    return service.addPlayer(p);
  }

  @PutMapping("/players/{id}")
  public Player updatePlayer(@PathVariable int id ,@RequestBody Player p){
    return service.updatePlayer(id,p);
  }

  //partial Update
  @PatchMapping("/players/{id}")
  public Player partialUpdate(@PathVariable int id, @RequestBody Map<String,Object> patchData){
    return service.patchPlayer(id,patchData);
  }

  // @PatchMapping("/players/{id}/titles")
  // public void updateTitles(@PathVariable int id, @RequestBody int titles){
  //   service.updateTitles(id, titles);
  // }

  @DeleteMapping("/players/{id}")
  public String deletePlayer(@PathVariable int id){
    return service.deletePlayer(id);
  }

  @PutMapping("/players/{id}/profiles/{profile_id}")
  public Player assignDetail(@PathVariable int id, @PathVariable int profile_id) {
    PlayerProfile profile = profileService.getPlayerProfile(profile_id);
    System.out.println(profile);
    return service.assignProfile(id, profile);
  }
}
