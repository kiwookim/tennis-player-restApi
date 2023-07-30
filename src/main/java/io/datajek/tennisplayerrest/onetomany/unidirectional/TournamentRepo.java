package io.datajek.tennisplayerrest.onetomany.unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository <Tournament, Integer> {

}
