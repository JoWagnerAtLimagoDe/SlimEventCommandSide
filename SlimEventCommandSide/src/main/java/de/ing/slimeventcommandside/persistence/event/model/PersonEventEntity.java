package de.ing.slimeventcommandside.persistence.event.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_personen_events")
@NamedQuery(name = "PersonEventEntity.findAllEventsByPersonId",query = "select e from PersonEventEntity e where e.personID = :personID order by e.timestamp")
public class PersonEventEntity {
	
	@Id @Column(length = 36, nullable = false) private String eventID;
	private LocalDateTime timestamp;
	@Enumerated(EnumType.STRING)
	private PersonEventType type;
	@Column(length = 36, nullable = false) private String personID;
	@Column(length = 30, nullable = false) private String vorname;
	@Column(length = 30, nullable = false) private String nachname;

}
