package com.example.demo.domain.entities.dtos;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ActorShort {
	int getActorId();
	
	@JsonProperty("nombre")
	@Value("#{target.lastName + ', ' + target.firstName}")
	String getNombreCompleto();
 }
