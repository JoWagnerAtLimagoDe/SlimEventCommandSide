package de.ing.slimeventcommandside.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ing.slimeventcommandside.persistence.event.PersonEventRepository;
import de.ing.slimeventcommandside.persistence.event.model.PersonEventEntity;

@RestController
@RequestMapping("/events")
public class PersonEventController {

	private final PersonEventRepository personEventRepository;
	
	
	
	public PersonEventController(final PersonEventRepository personEventRepository) {
		this.personEventRepository = personEventRepository;
	}


	@GetMapping(path="/event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonEventEntity> getPersonEventEntityById(@PathVariable String id) {
		final Optional<PersonEventEntity> personEventEntity = personEventRepository.findById(id);
		return ResponseEntity.of(personEventEntity);
	}
	
	@GetMapping(path="/all/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonEventEntity>> getPersonEventEntityByPersonId(@PathVariable String id) {
		return ResponseEntity.ok(personEventRepository.findAllEventsByPersonId(id));
	}
	
}
