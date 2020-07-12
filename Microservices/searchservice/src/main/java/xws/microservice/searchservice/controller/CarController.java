package xws.microservice.searchservice.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.services.CarService;

@RestController
@RequestMapping(value = "/automobil")
@CrossOrigin(origins = "*")
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

	@GetMapping(value = "/marke")
	public ResponseEntity<?> getAllMarks(){
		ArrayList<Car> carArrayList = carService.getAll();
		Set<String> carMarks = new HashSet<String>();

		for( Car car : carArrayList ){
			carMarks.add(car.getCarMark());
		}

		return new ResponseEntity<>(carMarks, HttpStatus.OK);

	}

	@GetMapping(value = "/modeli")
	public ResponseEntity<?> getAllModels(){
		ArrayList<Car> carArrayList = carService.getAll();
		Set<String> carModels= new HashSet<String>();

		for( Car car : carArrayList ){
			carModels.add(car.getCarModel());
		}

		return new ResponseEntity<>(carModels, HttpStatus.OK);
	}


	@GetMapping(value = "/klase")
	public ResponseEntity<?> getAllCarClasses(){
		ArrayList<Car> carArrayList = carService.getAll();
		Set<String> carClasses= new HashSet<String>();

		for( Car car : carArrayList ){
			carClasses.add(car.getCarClass());
		}

		return new ResponseEntity<>(carClasses, HttpStatus.OK);
	}

	@GetMapping(value = "/prenos")
	public ResponseEntity<?> getAllCarTransmission(){

		HashSet<String> transmissionSet = carService.getAllTransmission();

		return new ResponseEntity<>(transmissionSet,HttpStatus.OK);

	}

	@GetMapping(value = "/gorivo")
	public ResponseEntity<?> getAllCarFuel(){

		HashSet<String> carFuelSet = carService.getAllCarFuel();

		return new ResponseEntity<>(carFuelSet,HttpStatus.OK);

	}
}
