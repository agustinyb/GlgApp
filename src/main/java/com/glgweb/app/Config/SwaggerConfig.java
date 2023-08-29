package com.glgweb.app.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Global Logistics API")
                        .version("0.1")
                        .description("Api for Customers")
                        .termsOfService("http://glgapp.com/terms"));
    }
}
