package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		// dao.findByActorIdNotNull(ActorDTO.class).stream().forEach(a -> System.out.println(a));
		// dao.findByActorIdNotNull(ActorDTO.class).stream().forEach(a -> System.out.println(ActorDTO.from(a)));
		// dao.findByActorIdNotNull(ActorShort.class).stream().forEach(a -> System.out.println(a.getNombreCompleto()));
		dao.findByActorIdNotNull(ActorDTO.class).stream().forEach(a -> System.out.println(a.getNombreCompleto()));
	}

}
