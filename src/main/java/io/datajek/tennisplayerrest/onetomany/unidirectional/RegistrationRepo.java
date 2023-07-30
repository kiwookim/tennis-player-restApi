package io.datajek.tennisplayerrest.onetomany.unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository <Registration,Integer> {

}
