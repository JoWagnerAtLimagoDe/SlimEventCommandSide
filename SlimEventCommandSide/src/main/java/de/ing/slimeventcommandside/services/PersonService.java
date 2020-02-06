package de.ing.slimeventcommandside.services;

import java.util.List;
import java.util.Optional;

import de.ing.slimeventcommandside.controllers.models.Person;

public interface PersonService {

	void save(Person person);

	void update(Person person);

	void delete(Person person);

	List<Person> findAll();

	Optional<Person> findByID(String id);

}