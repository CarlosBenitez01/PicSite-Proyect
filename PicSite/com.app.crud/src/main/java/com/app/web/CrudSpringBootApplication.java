package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.repositorio.UsuarioRepositorio;


@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);

	}	
	
	@Autowired
	private UsuarioRepositorio repositorioUsu;

	@Override
	public void run(String... args) throws Exception {
		/*
		Estudiante estudiante1 = new Estudiante("Carlos", "Benitez", "cb653473@gmail.com");
		repositorio.save(estudiante1);
		
		Estudiante estudiante2 = new Estudiante("Francisco", "Quintanilla", "yufwgei72@gmail.com");
		repositorio.save(estudiante2);
		
		Usuario usu1 = new Usuario("Carlos", "cb653473@gmail.com", "123fwefwe");
		repositorioUsu.save(usu1);
		
		Usuario usu2 = new Usuario("Melissa", "mlfywegf21@gmail.com", "fdiuwey6");
		repositorioUsu.save(usu2);
	*/	
	}
}
