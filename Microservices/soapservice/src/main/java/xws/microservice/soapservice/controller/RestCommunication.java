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
@RequestMapping(value="/")
public class RestCommunication {

    @Autowired
    private SoapClient soapClient;

    @GetMapping("car/{id}")
    public ResponseEntity<String> car(@PathVariable Long id){
        String carId = soapClient.getCarResponse(id).getCar().getOwner();

        return new ResponseEntity<>(carId , HttpStatus.OK);
    }

    @GetMapping("rentadvert/{id}")
    public ResponseEntity<String> rentadvert(@PathVariable Long id){
        String rentAdvertId = soapClient.getRentAdvert(id).getRentAdvert().getOwner();

        return new ResponseEntity<>(rentAdvertId,HttpStatus.OK);

    }

    @GetMapping("pricelist/{id}")
    public ResponseEntity<String> pricelist(@PathVariable Long id){
        String pricelistId = soapClient.getPriceListResponse(id).getPriceList().getOwner();

        return new ResponseEntity<>(pricelistId,HttpStatus.OK);

    }
}
