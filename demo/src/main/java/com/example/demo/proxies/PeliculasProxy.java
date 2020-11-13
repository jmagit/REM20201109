package com.example.demo.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.entities.dtos.CatalogoDTO;
import com.example.demo.domain.entities.dtos.FilmShortDTO;

//@FeignClient(name="catalogo", url="http://localhost:8001")
@FeignClient(name="CATALOGO-SERVICE")
public interface PeliculasProxy {
	@GetMapping("/peliculas?mode=short")
	List<FilmShortDTO> getAll();
	@GetMapping("/peliculas/{id}?mode=short")
	FilmShortDTO getOne(@PathVariable int id);

	@GetMapping("/")
	String getCatalogo();

}
