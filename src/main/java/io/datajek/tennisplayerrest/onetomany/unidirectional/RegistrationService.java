package io.datajek.tennisplayerrest.onetomany.unidirectional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepo repo;

	public List<Registration> allRegistrations() {
		return repo.findAll();
	}

	public Registration getRegistration(int id){
		return repo.findById(id).get();
	}

  public Registration addRegistration(Registration registration) {
    registration.setId(0);
		return repo.save(registration);
	}

 	public void deleteRegistration(int id) {
		repo.deleteById(id);
	}
}
