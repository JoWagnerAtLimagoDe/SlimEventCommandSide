package de.ing.slimeventcommandside.persistence.person;

import org.springframework.data.repository.CrudRepository;

import de.ing.slimeventcommandside.persistence.personen.model.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, String> {

}
