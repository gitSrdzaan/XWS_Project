package xws.microservice.soapservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xws.microservice.soapservice.soapclient.SoapClient;

@RestController
@RequestMapping(value="/s")
public class RestCommunication {

    @Autowired
    private SoapClient soapClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> car(@PathVariable Long id){
        String carId = soapClient.getRentAdvert(id).getRentAdvert().getOwner();

        return new ResponseEntity<>(carId , HttpStatus.OK);
    }
}
