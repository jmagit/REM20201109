package com.example.demo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.entities.Actor;
import com.example.demo.infraestructure.repositories.ActorRepository;

public class ActorService {
	@Autowired
	ActorRepository dao;
	
	public List<Actor> getAll() {
		return dao.findAll();
	}
	public Optional<Actor> getOne(int id) {
		return null;
	}
	public Actor add(Actor item) {
		return null;
	}
	public Actor change(Actor item) {
		return null;
	}
	public void delete(Actor item) {
		delete(item.getActorId());;
	}
	public void delete(int id) {
	}

}
