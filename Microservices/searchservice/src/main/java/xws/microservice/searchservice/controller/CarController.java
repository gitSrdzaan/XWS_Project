package xws.microservice.searchservice.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.services.CarService;

@RestController
@RequestMapping(value = "/car")
@CrossOrigin(origins = "*")
public class CarController {
	
	@Autowired
	private CarService carService;

	@GetMapping(path = "/getCar/{CarId}", produces = MediaType.APPLICATION_JSON_VALUE)
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

	@GetMapping(value = "/marks", produces = "application/json")
	public ResponseEntity<?> getAllMarks(){
		ArrayList<Car> carArrayList = carService.getAll();
		Set<String> carMarks = new HashSet<String>();

		for( Car car : carArrayList ){
			carMarks.add(car.getCarMark());
		}

		return new ResponseEntity<>(carMarks, HttpStatus.OK);

	}

	@GetMapping(value = "/models", produces = "application/json")
	public ResponseEntity<?> getAllModels(){
		ArrayList<Car> carArrayList = carService.getAll();
		Set<String> carModels= new HashSet<String>();

		for( Car car : carArrayList ){
			carModels.add(car.getCarModel());
		}

		return new ResponseEntity<>(carModels, HttpStatus.OK);
	}


	@GetMapping(value = "/classes", produces = "application/json")
	public ResponseEntity<?> getAllCarClasses(){
		ArrayList<Car> carArrayList = carService.getAll();
		Set<String> carClasses= new HashSet<String>();

		for( Car car : carArrayList ){
			carClasses.add(car.getCarClass());
		}

		return new ResponseEntity<>(carClasses, HttpStatus.OK);
	}

	@GetMapping(value = "/transmissions", produces = "application/json")
	public ResponseEntity<?> getAllCarTransmission(){

		HashSet<String> transmissionSet = carService.getAllTransmission();

		return new ResponseEntity<>(transmissionSet,HttpStatus.OK);

	}

	@GetMapping(value = "/fuels", produces = "application/json")
	public ResponseEntity<?> getAllCarFuel(){

		HashSet<String> carFuelSet = carService.getAllCarFuel();

		return new ResponseEntity<>(carFuelSet,HttpStatus.OK);

	}

    @GetMapping(value = "/registration", produces = "application/json")
    public ResponseEntity<?> getAllCarRegs(){

        HashSet<String> carRegSet = carService.getAllCarRegs();

        return new ResponseEntity<>(carRegSet,HttpStatus.OK);

    }


	@PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){

		try {

			carService.addCar(carDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri dodavanju automobila",HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
