package com.example.demo.domain.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.domain.entities.Actor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDTO {
	private int actorId;
	@NotBlank
	@Size(max = 45)
	private String firstName;
	private String lastName;

	public String getNombreCompleto() { return getFirstName() + " " + getLastName(); }
	
	public static Actor from(ActorDTO source) {
		return new Actor (
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
	public static ActorDTO from(Actor source) {
		return new ActorDTO (
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
}
