package com.example.demo.models.dtos;

import java.io.Serializable;

import com.example.demo.models.Actor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDTO implements Serializable {
	private int actorId;
	private String firstName;
	private String lastName;
	
	public static ActorDTO from(Actor source) {
		return new ActorDTO(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName());
	}

	public static Actor from(ActorDTO source) {
		return new Actor(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName());
	}

}
