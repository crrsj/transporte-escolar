package br.com.escolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API - Sistema para donos de transporte escolar.",
			version = "1.0",
			description = "Documentando uma API para um sistema de suporte para donos de transporte escolar.",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class TransporteEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransporteEscolarApplication.class, args);
	}

}
