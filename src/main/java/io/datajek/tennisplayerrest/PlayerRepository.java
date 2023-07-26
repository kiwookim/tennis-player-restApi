package io.datajek.tennisplayerrest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
  // Simply by extending the JpaRepository, we get all basic CRUD operations like findAll(), findById(), save(), and deleteById() etc.,
  // without having to write any implementation.
}
