package de.ing.slimeventcommandside.acl;

import org.springframework.stereotype.Component;

import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.persistence.personen.model.PersonEntity;


@Component
public class PersonToPersonEntityConverterImpl implements PersonToPersonEntityConverter {
	
	@Override
	public Person convert(PersonEntity entity) {
		return Person.builder()
				.personID(entity.getPersonID())
				.vorname(entity.getVorname())
				.nachname(entity.getNachname())
				.build();
	}

	@Override
	public PersonEntity convert(Person person) {
		return PersonEntity.builder()
				.personID(person.getPersonID())
				.vorname(person.getVorname())
				.nachname(person.getNachname())
				
				.build();
	}

}
