package xws.microservice.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xws.microservice.searchservice.dto.FirmDTO;
import xws.microservice.searchservice.services.FirmService;

@RestController
@RequestMapping(value = "/firma")
public class FirmController {

    @Autowired
    private FirmService firmService;


    @GetMapping(value = "/prikaz/{firmID}")
    public ResponseEntity<?> getFirmInfo(@PathVariable Long firmID){

        FirmDTO firmDTO = firmService.findFirm(firmID);
        if(firmDTO == null){
            return  new ResponseEntity<>("Firma ne postoji", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(firmDTO,HttpStatus.OK);
    }
}
