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
prodServer.setDescription("Server URL in Production environment");
Contact contact = new Contact();
contact.setEmail("digoncaldaw@gmail.com");
contact.setName("Diana Goncalves");
contact.setUrl("https://github.com/Noihirsch/PocketHero?tab=readme-ov-file");
License gplLicense = new License().name("GNU General Public License v3.0").url("https://choosealicense.com/licenses/gpl-3.0/");

Info info = new Info()
    .title("Pocket API")
    .version("1.0")
    .contact(contact)
    .description("An API that returns information for the Pocket Hero web application by Diana Goncalves")
    .termsOfService("https://creativecommons.org/licenses/by-nc-sa/4.0/?ref=chooser-v1")
    .license(gplLicense);

return new OpenAPI().info(info).servers(List.of(prodServer));
}
}