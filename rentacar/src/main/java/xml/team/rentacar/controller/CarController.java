package xml.team.rentacar.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.team.rentacar.dto.CarDTO;
import xml.team.rentacar.model.*;
import xml.team.rentacar.service.CarService;

@RestController
@RequestMapping(value = "/auta")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	@GetMapping(path = "/svi")
	public ResponseEntity<?> findAll(){
		List<Car> cars = carService.findAll();
		if (cars == null) {
			return new ResponseEntity<>("Greska pri ispisu automobila",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(cars,HttpStatus.OK);
	}
	
	@PostMapping(path = "/novi", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){
		
		System.out.println(carDTO.getCarClass());
		CarMark mark = carService.findMark(carDTO.getCarMark());
		if(mark == null) {
			return new ResponseEntity<>("Marka automobila nije izabrana",HttpStatus.BAD_REQUEST);
		}
		CarModel model = carService.modelExsits(mark, carDTO.getCarModel());
		if(model == null) {
			return new ResponseEntity<>("Model automobila nije izabrana",HttpStatus.BAD_REQUEST);

		}
		CarClass carClass = carService.classExsits(model,carDTO.getCarClass());
		if(carClass == null){
			return new ResponseEntity<>("Klasa automobila nije izabrana",HttpStatus.BAD_REQUEST);
		}

		try {
			Car car = new Car();
			//car.setId(carDTO.getId());
			car.setCarMark(carDTO.getCarMark());
			car.setCarModel(carDTO.getCarModel());
			car.setCarClass(carDTO.getCarClass());
			car.setCarFuel(carDTO.getCarFuel());
			car.setTransmission(carDTO.getTransmission());
			car.setCarRegistration(carDTO.getCarRegistration());
			car.setCarMileage(carDTO.getCarMileage());
			car.setMaxAllowedMileage(carDTO.getMaxAllowedMileage());
			car.setCarGrade(carDTO.getCarGrade());
			car.setKidsSeats(carDTO.getKidsSeats());
			/*
			car.setLatitude(carDTO.getLatitude());
			car.setLongitude(carDTO.getLongitude());

			 */
			carService.addCar(car);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri dodavanju automobila",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "marke")
	public ResponseEntity<?> findAllCarMarks(){
		ArrayList<CarMark> listMark = carService.findAllCarMarks();
		if(listMark == null) {
			return new ResponseEntity<>("Lista marki automobila prazna", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(listMark,HttpStatus.OK);


	}

	@GetMapping(value = "klase")
	public ResponseEntity<?> findAllCarClasses(){
		ArrayList<CarClass> listClass = carService.findAllCarClasses();
		if(listClass == null) {
			return new ResponseEntity<>("Lista klasi automobila prazna", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(listClass,HttpStatus.OK);


	}



	@GetMapping(value = "modeli")
	public ResponseEntity<?> findAllCarModels(){
		ArrayList<CarModel> listModel = carService.findAllCarModels();
		if(listModel == null) {
			return new ResponseEntity<>("Lista modeli automobila prazna", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(listModel,HttpStatus.OK);


	}


	@GetMapping(value = "/prenosi")
	public ResponseEntity<?> getAllCarTransmission(){
		ArrayList<Transmission> transmissionArrayList = carService.getAllTransmission();

		return new ResponseEntity<>(transmissionArrayList,HttpStatus.OK);

	}

	@GetMapping(value = "/goriva")
	public ResponseEntity<?> getAllCarFuel(){

		ArrayList<CarFuel> carFuelSet = carService.getAllCarFuel();

		return new ResponseEntity<>(carFuelSet,HttpStatus.OK);

	}

}
