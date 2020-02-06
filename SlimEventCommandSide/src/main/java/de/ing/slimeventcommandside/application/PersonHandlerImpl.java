package de.ing.slimeventcommandside.application;

import javax.transaction.Transactional;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import de.ing.slimeventcommandside.acl.PersonToEventBuilder;
import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.events.PersonEvent;
import de.ing.slimeventcommandside.events.messaging.ApplicationChannels;
import de.ing.slimeventcommandside.persistence.event.PersonEventRepository;
import de.ing.slimeventcommandside.persistence.event.model.PersonEventEntity;
import de.ing.slimeventcommandside.services.PersonService;

@Component
@Transactional
public class PersonHandlerImpl implements PersonHandler {
	
	private final ApplicationChannels channels;
	private final PersonToEventBuilder converter;
	private final PersonEventRepository repository;
	private final PersonService service;
	
	
	
	public PersonHandlerImpl(final ApplicationChannels channels, final PersonToEventBuilder converter,final PersonEventRepository repository, final PersonService service) {
		this.channels = channels;
		this.converter = converter;
		this.repository = repository;
		this.service = service;
	}

	@Override
	public void handleInsert(Person person) {
		
	
		service.save(person);
		
		PersonEventEntity entity = converter.createInsertEvent(person);
		repository.save(entity);
		
		
		Message<PersonEvent> event = createEventMessage(person);
		channels.personInsertedOut().send(event);
		
	}


	@Override
	public void handleUpdate(Person person) {
		
		service.update(person);
		
		PersonEventEntity entity = converter.createUpdateEvent(person);
		repository.save(entity);
		
		Message<PersonEvent> event = createEventMessage(person);
		channels.personUpdatedOut().send(event);
		
	}

	@Override
	public void handleDelete(Person person) {
		
		service.delete(person);
		
		PersonEventEntity entity = converter.createDeleteEvent(person);
		repository.save(entity);
		
		Message<PersonEvent> event = createEventMessage(person);
		channels.personDeletedOut().send(event);
	}

	
	
	private Message<PersonEvent> createEventMessage(Person person) {
		Message<PersonEvent> event = MessageBuilder.withPayload(PersonEvent.builder().personID(person.getPersonID()).build()).build();
		return event;
	}

}
