package com.ohgiraffers.createentityandrestapiswagger.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .components(new Components())
                .info(swaggerInfo());
    }

    private Info swaggerInfo() {
        return new Info()
                .title("Insta API")
                .description("SpringBoot Swagger 연동 연습")
                .version("1.0.0");
    }

}