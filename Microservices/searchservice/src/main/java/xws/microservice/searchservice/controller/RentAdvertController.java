package xws.microservice.searchservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	private FirmService firmService;

	@Autowired
	private UserService userService;
	
	/*
	@GetMapping(path = "/pretrazivanjeAutomobila")
	public ResponseEntity<?> searchRentAdvert(@RequestBody RentAdvert ra){

		try {
			List<RentAdvert> rentAdvert = rentAdvertService.searchRentAdvert(ra.getCar().getLongitude(), ra.getCar().getLatitude(), ra.getAdvertStartDate(), ra.getAdvertEndDate());
				return new ResponseEntity<>(rentAdvert.getClass(), HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Ni jedan auto ne odgovara parametrima", HttpStatus.BAD_REQUEST);
		}	

		
	}
	*/
	
}
