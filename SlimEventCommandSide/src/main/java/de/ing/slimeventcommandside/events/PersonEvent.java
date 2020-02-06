package de.ing.slimeventcommandside.events;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import de.ing.slimeventcommandside.persistence.personen.model.PersonEntity;
import de.ing.slimeventcommandside.persistence.personen.model.PersonEntity.PersonEntityBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEvent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -85637573113232051L;
	@Builder.Default private String eventID = UUID.randomUUID().toString();
	@Builder.Default private LocalDateTime localDateTime = LocalDateTime.now();
	private String personID;

}
