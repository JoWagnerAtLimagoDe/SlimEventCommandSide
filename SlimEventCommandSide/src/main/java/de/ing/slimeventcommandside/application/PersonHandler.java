package de.ing.slimeventcommandside.application;

import de.ing.slimeventcommandside.controllers.models.Person;

public interface PersonHandler {

	void handleInsert(Person person);

	void handleUpdate(Person person);

	void handleDelete(Person person);

	

}