package de.ing.slimeventcommandside.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ing.slimeventcommandside.application.PersonHandler;
import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.services.PersonService;


@RestController
@RequestMapping("/personen")
public class PersonController {
	
	private final PersonHandler handler;
	private final PersonService service;
	
	
	
	public PersonController(PersonHandler handler, PersonService service) {
		super();
		this.handler = handler;
		this.service = service;
	}

	@GetMapping(path = "/person/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findPersonById(@PathVariable String id) {
		return ResponseEntity.of(service.findByID(id));
	}

	@GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> findAllPersons() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PutMapping(path = "/insert",consumes  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@RequestBody Person person) {
		handler.handleInsert(person);
		return ResponseEntity.ok().build();
	}

	@PutMapping(path = "/update",consumes  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@RequestBody  Person person) {
		handler.handleUpdate(person);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(path = "/delete",consumes  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@RequestBody  Person person) {
		handler.handleDelete(person);
		return ResponseEntity.ok().build();
	}

	
	




}
