package xws.microservice.authentificationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/a")
public class HelloWorld {

	@GetMapping
	public ResponseEntity<String> pozdrav(){
        String ime = "Hello World authentification";
        return new ResponseEntity<>(ime, HttpStatus.OK) ;
    }
	
}
