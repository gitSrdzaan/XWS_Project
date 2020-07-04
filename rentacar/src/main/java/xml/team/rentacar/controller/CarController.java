package xml.team.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.team.rentacar.dto.CarDTO;
import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.CarClass;
import xml.team.rentacar.model.CarMark;
import xml.team.rentacar.model.CarModel;
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
		CarClass cc = carService.classExsits(model, carDTO.getCarClass());
		if( cc == null) {
			return new ResponseEntity<>("Klasa automobila nije izabrana",HttpStatus.BAD_REQUEST);

		}
		
		
		try {
			Car car = new Car();
			car.setId(carDTO.getId());
			car.setCarMark(carDTO.getCarMark());
			car.setCarModel(carDTO.getCarModel());
			car.setCarClass(carDTO.getCarClass());
			car.setCarFuel(carDTO.getCarFuel());
			car.setTransmission(carDTO.getTransmission());
			car.setCarRegistration(carDTO.getCarRegistration());
			car.setCarMileage(carDTO.getCarMileage());
			car.setCarComment(carDTO.getCarComment());
			car.setCarGrade(carDTO.getCarGrade());
			car.setKidsSeats(carDTO.getKidsSeats());
			car.setLatitude(carDTO.getLatitude());
			car.setLongitude(carDTO.getLongitude());
			carService.addCar(car);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri dodavanju automobila",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
