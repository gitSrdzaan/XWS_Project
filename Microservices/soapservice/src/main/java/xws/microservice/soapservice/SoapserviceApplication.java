package xws.microservice.soapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SoapserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapserviceApplication.class, args);
	}

}
