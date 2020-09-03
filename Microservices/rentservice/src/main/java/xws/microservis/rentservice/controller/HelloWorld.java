package xws.microservis.rentservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/a")
public class HelloWorld {



	@GetMapping
	public ResponseEntity<String> pozdrav(){
        String ime = "Hello World rent";
        return new ResponseEntity<>(ime, HttpStatus.OK) ;
    }


	
}
