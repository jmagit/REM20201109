package com.example.demo.domain.entities.dtos;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.domain.entities.Category;

@Projection(name = "CategoryShort", types = Category.class)
public interface CategoryShort {
	byte getCategoryId();
	String getName();
}
