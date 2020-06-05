package xws.microservis.advertservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdvertserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertserviceApplication.class, args);
		
	}

}
