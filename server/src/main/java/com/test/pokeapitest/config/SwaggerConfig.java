package com.test.pokeapitest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
        new Info()
            .title("Pokemon API Test")
            .description("API para testar as APIs da PokeAPI")
            .version("v1")
            .license(
                new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0"))
            .contact(new Contact()
                .name("Luan Medeiros Silveira")
                .url("https://github.com/luanmedeirossilveira")
                .email("luanmedeirossilveira@gmail.com")));
  }
}
