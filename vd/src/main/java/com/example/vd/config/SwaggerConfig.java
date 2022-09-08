package com.example.vd.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "VDcom Test Task",
                version = "1.0",
                contact = @Contact(
                        name = "Andrew Kraskovich",
                        url = "",
                        email = "gemius99@gmail.com"
                )
        )
)
@Configuration
public class SwaggerConfig {
}
