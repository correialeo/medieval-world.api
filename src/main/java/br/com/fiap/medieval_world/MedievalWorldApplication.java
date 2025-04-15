package br.com.fiap.medieval_world;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Medieval World API", version = "v1", description = "API do Medieval World",
		contact = @Contact(name = "Leandro Correia", email = "leandro@medievalworld.com")))
public class MedievalWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedievalWorldApplication.class, args);
	}

}
