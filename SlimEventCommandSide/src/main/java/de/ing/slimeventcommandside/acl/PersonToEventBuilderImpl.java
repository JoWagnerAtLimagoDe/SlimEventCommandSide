package de.ing.slimeventcommandside.acl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.persistence.event.model.PersonEventEntity;
import de.ing.slimeventcommandside.persistence.event.model.PersonEventType;


@Component
public class PersonToEventBuilderImpl implements PersonToEventBuilder {
	
	@Override
	public PersonEventEntity createInsertEvent(Person person) {
		PersonEventEntity personEventEntity = createBaseEntity(person);
		
		personEventEntity.setType(PersonEventType.INSERT);
		
		return personEventEntity;
		
	}
	
	
	@Override
	public PersonEventEntity createUpdateEvent(Person person) {
		PersonEventEntity personEventEntity = createBaseEntity(person);
		
		personEventEntity.setType(PersonEventType.UPDATE);
		
		return personEventEntity;
		
	}
	
	
	@Override
	public PersonEventEntity createDeleteEvent(Person person) {
		PersonEventEntity personEventEntity = createBaseEntity(person);
		
		personEventEntity.setType(PersonEventType.DELETE);
		
		return personEventEntity;
		
	}
	
	
	

	private PersonEventEntity createBaseEntity(Person person) {
		PersonEventEntity personEventEntity =  PersonEventEntity.builder()
			.eventID(UUID.randomUUID().toString())
			.timestamp(LocalDateTime.now())
			.personID(person.getPersonID())
			.vorname(person.getVorname())
			.nachname(person.getNachname())
			.build();
		return personEventEntity;
	}

}
