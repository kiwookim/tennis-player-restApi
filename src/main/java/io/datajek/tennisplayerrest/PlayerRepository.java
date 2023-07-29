package io.datajek.tennisplayerrest;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
  // Simply by extending the JpaRepository, we get all basic CRUD operations like findAll(), findById(), save(), and deleteById() etc.,
  // without having to write any implementation.
  // @Modifying
  // @Query("update Player p set p.titles = :titles where p.id = :id")
  // void updateTitles(@Param("id") int id, @Param("titles") int titles);
}
