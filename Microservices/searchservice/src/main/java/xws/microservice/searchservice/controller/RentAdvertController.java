package xws.microservice.searchservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.RentAdvert;
import xws.microservice.searchservice.services.CarService;
import xws.microservice.searchservice.services.FirmService;
import xws.microservice.searchservice.services.RentAdvertService;
import xws.microservice.searchservice.services.UserService;

@RestController
@RequestMapping(value = "/pretrazivanje")
public class RentAdvertController {

	@Autowired
	private RentAdvertService rentAdvertService;
	
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/helloworld")
	public ResponseEntity<?> helloWorld(){
		return new ResponseEntity<> ("HelloWorld iznajmljivanje service", HttpStatus.OK);
	}
	
	@GetMapping(path = "/pretrazivanjeAutomobila/{raId}")
	public ResponseEntity<?> searchRentAdvert(@PathVariable Long raId){

		RentAdvertDTO rentAdvert = new RentAdvertDTO();
		
		try {
			rentAdvert = rentAdvertService.findRentAdvert(raId);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Ne postoji oglas", HttpStatus.BAD_REQUEST);
		}
		
		//Car car = rentAdvert.getCar();
		
		try {
			CarDTO carDTO = carService.findCar(raId);
			if(carDTO == null) {
				return new ResponseEntity<>("Auto ne pripada oglasu", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(carDTO, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Automobil ne postoji", HttpStatus.BAD_REQUEST);
		}
		
		/*
		try {
			List<RentAdvert> rentAdvert = rentAdvertService.searchRentAdvert(ra.getCar().getLongitude(), ra.getCar().getLatitude(), ra.getAdvertStartDate(), ra.getAdvertEndDate());
				return new ResponseEntity<>(rentAdvert.getClass(), HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Ni jedan auto ne odgovara parametrima", HttpStatus.BAD_REQUEST);
		}	

		*/
	}
	
	
}
