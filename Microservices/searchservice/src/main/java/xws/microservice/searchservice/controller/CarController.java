package xws.microservice.searchservice.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.services.CarService;

@RestController
@RequestMapping(value = "/automobil")
public class CarController {
	
	@Autowired
	private CarService carService;

	@GetMapping(path = "/prikaz/{CarId}")
	public ResponseEntity<?> findCar(@PathVariable Long CarId){
		CarDTO carDTO = new CarDTO();
		
		try {
			carDTO = carService.findCar(CarId);
			
			return new ResponseEntity<>(carDTO, HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("GRESKA Automobil ne postoji", HttpStatus.BAD_REQUEST);
			
		}
		
	}
}
