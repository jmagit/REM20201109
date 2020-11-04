package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import lombok.Value;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo.");
	}

}
