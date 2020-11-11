package com.example.demo.domain.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.contracts.ActorService;
import com.example.demo.domain.entities.Actor;
import com.example.demo.domain.entities.Film;
import com.example.demo.domain.entities.dtos.ActorDTO;
import com.example.demo.domain.entities.dtos.ActorShort;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.InvalidDataException;
import com.example.demo.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "actores")
public class ActorResource {
	@Autowired
	ActorService srv;
	
	@GetMapping
	Page<ActorShort> getAll(Pageable page) {
		return srv.getAllIn(ActorShort.class, page);
	}
	@GetMapping(path = "{id}")
	ActorDTO get(@PathVariable int id) throws NotFoundException {
		Optional<Actor> item = srv.getOne(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return ActorDTO.from(item.get());
	}
	@GetMapping(path = "{id}/peliculas")
	@Transactional
	List<Film> getFilms(@PathVariable int id) throws NotFoundException {
		Optional<Actor> item = srv.getOne(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return item.get().getFilmActors().stream().map(o -> o.getFilm()).collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ActorDTO item) throws BadRequestException, InvalidDataException {
		Actor newItem = ActorDTO.from(item);
		if(newItem.isInvalid())
			throw new BadRequestException("Datos invalidos");
		newItem = srv.add(newItem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newItem.getActorId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable int id, @Valid @RequestBody ActorDTO item) throws BadRequestException, NotFoundException, InvalidDataException {
		if(id != item.getActorId())
			throw new BadRequestException("Identificador incorrecto");
		Actor newItem = ActorDTO.from(item);
		if(newItem.isInvalid())
			throw new BadRequestException("Datos invalidos");
		srv.modify(newItem);
	}
	@PostMapping("/{id}/contrato")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void contratar(@PathVariable int id, @Valid @RequestBody ActorDTO item) throws BadRequestException, NotFoundException, InvalidDataException {
//		if(id != item.getActorId())
//			throw new BadRequestException("Identificador incorrecto");
//		Actor newItem = ActorDTO.from(item);
//		if(newItem.isInvalid())
//			throw new BadRequestException("Datos invalidos");
//		srv.modify(newItem);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) throws NotFoundException {
		srv.deleteById(id);
	}
}
