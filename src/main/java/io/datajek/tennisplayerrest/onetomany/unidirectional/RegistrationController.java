package io.datajek.tennisplayerrest.onetomany.unidirectional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
  @Autowired
  RegistrationService registrationService;

  @GetMapping
	public List<Registration> allRegistrations() {
		return registrationService.allRegistrations();
	}

	@GetMapping("/{id}")
	public Registration getRegistration(@PathVariable int id){
		return registrationService.getRegistration(id);
	}

  @PostMapping
	public Registration addRegistration(@RequestBody Registration registration) {
    return registrationService.addRegistration(registration);
	}

  @DeleteMapping("/{id}")
	public void deleteRegistration(@PathVariable int id) {
		registrationService.deleteRegistration(id);
	}
}
