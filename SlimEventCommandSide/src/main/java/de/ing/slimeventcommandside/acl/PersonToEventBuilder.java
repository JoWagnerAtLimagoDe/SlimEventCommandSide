package de.ing.slimeventcommandside.acl;

import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.persistence.event.model.PersonEventEntity;

public interface PersonToEventBuilder {

	PersonEventEntity createInsertEvent(Person person);

	PersonEventEntity createUpdateEvent(Person person);

	PersonEventEntity createDeleteEvent(Person person);
	
	

}