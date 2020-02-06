package de.ing.slimeventcommandside.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.ing.slimeventcommandside.acl.PersonToPersonEntityConverter;
import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.persistence.person.PersonRepository;
import de.ing.slimeventcommandside.persistence.personen.model.PersonEntity;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	private final PersonToPersonEntityConverter converter;
	
	
	
	public PersonServiceImpl(PersonRepository personRepository, PersonToPersonEntityConverter converter) {
		
		this.personRepository = personRepository;
		this.converter = converter;
	}
	
	@Override
	public void save(Person person) {
		PersonEntity entity = converter.convert(person);
		personRepository.save(entity);
	}
	
	
	@Override
	public void update(Person person) {
		save(person);
	}
	
	
	@Override
	public void delete(Person person) {
		personRepository.deleteById(person.getPersonID());
	}
	
	@Override
	public List<Person> findAll() {
		List<Person> retval = new ArrayList<>();
		personRepository.findAll().forEach((p)->retval.add(converter.convert(p)));
		return retval;
	}
	
	@Override
	public Optional<Person> findByID(String id) {
		Optional<PersonEntity> optional = personRepository.findById(id);
		
		if(optional.isPresent())
			return Optional.of(converter.convert(optional.get()));
		
		return Optional.empty();
		
	}
	
	
	
}
