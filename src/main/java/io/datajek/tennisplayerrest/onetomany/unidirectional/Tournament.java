package io.datajek.tennisplayerrest.onetomany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Tournament {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private String location;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="tournament_id")
  private List<Registration> registrations = new ArrayList<>();

  //constructor

  Tournament(){};

  Tournament(String name, String location){
    super();
    this.name = name;
    this.location = location;
  }
  //getters and setters
  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLocation(){
    return location;
  }
  public void setLocation(String location){
    this.location = location;
  }
  public List<Registration> getRegistrations(){
    return registrations;
  }
  public void setRegistration(List<Registration> registrations) {
    this.registrations = registrations;
  }
  //set up one to many relationship
  public void addRegistration(Registration newRegistration){
    registrations.add(newRegistration);
  }

  //remove registration
  public void removeRegistration(Registration reg) {
    if (registrations != null)
      registrations.remove(reg);
  }

  @Override
  public String toString() {
  return "Tournament [id=" + id + ", name=" + name + ", location=" + location + ", registrations=" + registrations
      + "]";
  }

}
