package com.ucr.algoritmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Domain.Cliente;
import Domain.Gerente;

@SpringBootApplication
public class ProyectoSpringAlgoritmosApplication {

	public static Gerente juan;
	public static Cliente daniel;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringAlgoritmosApplication.class, args);
		
		 juan = new Gerente("Juan Carlos","jumocrc@gmail.com","1234","Soy un gerente");
		 daniel = new Cliente("Daniel H","dh@gmail.com","1234","Soy un Cliente");
		
		
	}
}
