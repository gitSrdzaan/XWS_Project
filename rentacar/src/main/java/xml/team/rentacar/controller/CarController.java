package xml.team.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.team.rentacar.model.Car;
import xml.team.rentacar.service.CarService;

@RestController
@RequestMapping(value = "/auta")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	@GetMapping(value = "/svi")
	public ResponseEntity<?> findAll(){
		List<Car> cars = carService.findAll();
		if (cars == null) {
			return new ResponseEntity<>("Greska pri ispisu automobila",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(cars,HttpStatus.OK);
	}

}
