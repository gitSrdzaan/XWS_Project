package xws.microservis.rentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentserviceApplication.class, args);
	}

}
