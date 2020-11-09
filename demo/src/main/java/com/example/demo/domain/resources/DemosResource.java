package com.example.demo.domain.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demos")
public class DemosResource {

	@GetMapping
	public String saluda() {
		return "Hola mundo";
	}
	@GetMapping(path = "/despide")
	public String despide() {
		return "Adios mundo";
	}
	@GetMapping(path = "/despide/{nombre}")
	public String despide(@PathVariable String nombre) {
		return "Adios " + nombre;
	}

	@GetMapping(path = "/params/{id}", params = {"nom=hola"})
	public String cotillaSpecial(
	        @PathVariable String id,
	        @RequestParam(required = false, defaultValue = "mundo") String nom,
	        @RequestHeader("Accept-Language") String language) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("Demo params");
	    return sb.toString();
	}
	@GetMapping(path = "/params/{id}")
	public String cotilla(
	        @PathVariable String id,
	        @RequestParam(required = false, defaultValue = "mundo") String nom,
	        @RequestHeader("Accept-Language") String language) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    return sb.toString();
	}
	@GetMapping(path = "/tabla/{id}")
	public List<String> multiple(
	        @PathVariable String id,
	        @RequestParam(required = false, defaultValue = "mundo") String nom,
	        @RequestHeader("Accept-Language") String language) { 
		List rslt = new ArrayList<String>();
	    rslt.add("id: " + id + "\n");
	    rslt.add("nom: " + nom + "\n");
	    rslt.add("language: " + language + "\n");
	    return rslt;
	}
	@GetMapping(path = "/tabla/{id}", produces = { "application/xml" } )
	public String cotillaXML(
	        @PathVariable String id,
	        @RequestParam(required = false, defaultValue = "mundo") String nom,
	        @RequestHeader("Accept-Language") String language) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("En XML id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    return sb.toString();
	}

}
