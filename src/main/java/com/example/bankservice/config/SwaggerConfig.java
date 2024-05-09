package com.example.bankservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Bank Service API")
                .description("API documentation for bank service")
                .version("1.0.0")
                .contact(apiContact());

    }

    private Contact apiContact() {
        return new Contact()
                .email("vullnetsahiti2004@gmail.com");

    }
}

