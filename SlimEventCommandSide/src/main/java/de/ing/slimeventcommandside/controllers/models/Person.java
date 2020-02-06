package de.ing.slimeventcommandside.controllers.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Size(min = 36, max = 36) @NotBlank private String personID;
	@Size(max = 30) @NotBlank private String vorname;
	@Size(max = 30) @NotBlank private String nachname;
}
