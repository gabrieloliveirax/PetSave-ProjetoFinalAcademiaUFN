package com.PetSave.PetSave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação indicando que esta classe é a classe principal que inicializa a aplicação Spring Boot
@SpringBootApplication
public class PetSaveApplication {

	// Método principal que inicia a aplicação Spring Boot
	public static void main(String[] args) {
		// Inicia a aplicação Spring Boot, passando a classe principal e os argumentos da linha de comando
		SpringApplication.run(PetSaveApplication.class, args);
	}

}
