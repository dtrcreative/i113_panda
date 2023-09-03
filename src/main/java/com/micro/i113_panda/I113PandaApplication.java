package com.micro.i113_panda;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Panda"))
public class I113PandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(I113PandaApplication.class, args);
	}

}
