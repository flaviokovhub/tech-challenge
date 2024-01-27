package br.com.sistema.jfood;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Tech Challenge - jfood-api", version = "1.0", description = "Lanchonete"))
public class JfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfoodApplication.class, args);
	}

}
