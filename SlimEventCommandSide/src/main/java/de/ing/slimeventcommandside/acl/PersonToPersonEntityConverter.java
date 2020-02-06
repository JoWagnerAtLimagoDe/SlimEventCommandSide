package de.ing.slimeventcommandside.acl;

import de.ing.slimeventcommandside.controllers.models.Person;
import de.ing.slimeventcommandside.persistence.personen.model.PersonEntity;

public interface PersonToPersonEntityConverter {

	Person convert(PersonEntity entity);

	PersonEntity convert(Person person);

}