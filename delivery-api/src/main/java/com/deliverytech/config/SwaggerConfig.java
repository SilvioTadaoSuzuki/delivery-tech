package com.deliverytech.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Marca como classe de configuração do Spring.
public class SwaggerConfig {
    @Bean
    //Expõe um bean OpenAPI customizado para documentar a API.
    public OpenAI customOpenAPI () {
        return new OpenAPI()
            .info(new Info()
                .title("Delivery Tech API")
                .version("1.0")
                .description("API para sistema de delivery - FAT T3")
                .contact(new Contact()
                    .name("Delivery Tech Team")
                    .email("contato@deliverytech.com")));
    }
}

//Como usar: Permite acessar a documentaão interativa da API (Swagger UI) automaticamente.