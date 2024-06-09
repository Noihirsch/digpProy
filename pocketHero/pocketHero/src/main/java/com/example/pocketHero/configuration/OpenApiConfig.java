package com.example.pocketHero.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:9000");
        prodServer.setDescription("Pockt Hero API");
        Contact contact = new Contact();
        contact.setEmail("digoncaldaw@gmail.com");
        contact.setName("Diana Goncalves");
        contact.setUrl("https://github.com/Noihirsch");
        License gplLicense = new License().name("GPL").url("https://www.gnu.org/licenses/gpl-3.0.en.html");
        Info info = new Info()
                .title("Pocket Hero API")
                .version("1.0")
                .contact(contact)
                .description("API that retrieves data for the Pocket Hero app.")
                .termsOfService("https://www.gnu.org/licenses/gpl-3.0.en.html")
                .license(gplLicense);
        return new OpenAPI().info(info).servers(List.of(prodServer));
    }

    @Configuration
public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // Custom CSS
        registry.addResourceHandler("/custom-swagger-style.css")
                .addResourceLocations("classpath:/static/custom-swagger-style.css");
    }
}
}