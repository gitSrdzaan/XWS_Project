package xws.microservice.authentificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthentificationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationserviceApplication.class, args);
	}

}
