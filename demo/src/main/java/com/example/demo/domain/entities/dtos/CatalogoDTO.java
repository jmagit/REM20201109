package com.example.demo.domain.entities.dtos;

import lombok.Data;

@Data
public class CatalogoDTO {
	@Data
	public class CatalogoLinks {
		public class Href {
			private String href;
		}

		private Href self;
		private Href actores;
		private Href peliculas;
		private Href categorias;
		private Href idiomas;
		private Href novedades;
	}

	private CatalogoLinks _links;
}
