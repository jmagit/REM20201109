package com.example.demo.infraestructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	List<Actor> findByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
}
