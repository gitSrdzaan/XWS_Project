package xws.microservis.rentservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xws.microservis.rentservice.soap.SoapClient;

@RestController
@RequestMapping(value = "/a")
public class HelloWorld {


    private SoapClient soapClient;

	@GetMapping
	public ResponseEntity<String> pozdrav(){
        String ime = "Hello World rent";
        return new ResponseEntity<>(ime, HttpStatus.OK) ;
    }

    @GetMapping(path = "/soap/{id}")
    public ResponseEntity<String> testSoap(@PathVariable Long id){

	    //String carId = soapClient.getRentAdvert(id).getRentAdvert().getOwner();

	   // return new ResponseEntity<>(carId , HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
