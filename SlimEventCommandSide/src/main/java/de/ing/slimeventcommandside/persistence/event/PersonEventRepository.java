package de.ing.slimeventcommandside.persistence.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.ing.slimeventcommandside.persistence.event.model.PersonEventEntity;

public interface PersonEventRepository extends CrudRepository<PersonEventEntity, String> {
	
	List<PersonEventEntity> findAllEventsByPersonId(String personID);

}
