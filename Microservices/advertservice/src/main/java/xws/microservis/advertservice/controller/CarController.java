package xws.microservis.advertservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.service.CarService;

@RestController
@RequestMapping(value= "/car")
public class CarController {


    @Autowired
    private CarService carService;


    @PostMapping(value = "/new" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCar(@RequestBody Car car){
        if(car == null){
            return new ResponseEntity<>("Greska pri kreiranju auta", HttpStatus.BAD_REQUEST);
        }
        try{
            carService.saveNewCar(car);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Greska pri upisu auta", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/modify/{carId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> modifyCar(@RequestBody Car car){

        return new ResponseEntity<>(HttpStatus.OK);


    }
    /**
     * TODO : ispis sifrarnika
     * */




}
