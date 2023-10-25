package com.example.MongoProject.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ilya",
                        email = "Shchegolev.ilya@list.ru",
                        url = "https://github.com/lilpumpy19"
                ),
                description = "Open API documentation",
                title = "Swagger",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:8080"
                )
        }


)

public class OpenApiConfig {

}











