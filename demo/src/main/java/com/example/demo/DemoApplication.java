package com.example.demo;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.contracts.ActorService;
import com.example.demo.domain.core.EntityBase;
import com.example.demo.domain.entities.Actor;
import com.example.demo.domain.entities.dtos.ActorDTO;
import com.example.demo.domain.entities.dtos.ActorShort;
import com.example.demo.infraestructure.repositories.ActorRepository;

import lombok.Data;
import lombok.Value;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);		
	}

	@Autowired
	ActorRepository dao;
	
	@Autowired
	ActorService srv;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// System.out.println("Hola mundo.");
		
		// dao.findAll().stream().forEach(a -> System.out.println(a));
		// dao.findByFirstNameStartingWithOrderByLastNameDesc("P").stream().forEach(a -> System.out.println(a));
//		Optional<Actor> rslt = dao.findById(54);
//		if(rslt.isPresent()) {
//			Actor actor = rslt.get();
//			System.out.println(actor);
//			actor.getFilmActors().stream().forEach(o -> System.out.println(o.getFilm()));
//			// dao.findById(54).get().getFilmActors().stream().forEach(o -> System.out.println(o.getFilm()));
//		}
//		dao.findAll().stream().forEach(a -> System.out.println(ActorDTO.from(a)));
		// dao.findAll(Sort.by("firstName", "lastName").descending()).stream().forEach(a -> System.out.println(a));
		// dao.findAll(PageRequest.of(0, 10, Sort.by("firstName", "lastName").descending())).stream().forEach(a -> System.out.println(a));
		// dao.findByActorIdNotNull(ActorDTO.class).stream().forEach(a -> System.out.println(a));
		// dao.findByActorIdNotNull(ActorDTO.class).stream().forEach(a -> System.out.println(ActorDTO.from(a)));
		// dao.findByActorIdNotNull(ActorShort.class).stream().forEach(a -> System.out.println(a.getNombreCompleto()));
		// dao.findByActorIdNotNull(ActorDTO.class).stream().forEach(a -> System.out.println(a.getNombreCompleto()));
		// srv.getAll().stream().forEach(a -> System.out.println(a));
		// srv.getAllIn(ActorDTO.class, PageRequest.of(0, 10, Sort.by("firstName", "lastName").descending())).stream().forEach(a -> System.out.println(a));
//		Actor actor = new Actor(1, "Pepito", "12345678S");
//		if(actor.isInvalid())
//			actor.getErrors().stream().forEach(e -> System.out.println(e));
//		else 
//			System.out.println("Es valido");
//		srv.getErrors(actor).stream().forEach(e -> System.out.println(e));
//		srv.add(actor);
//		dao.save(actor);
	}

}
