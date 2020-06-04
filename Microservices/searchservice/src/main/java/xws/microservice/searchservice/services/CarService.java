package xws.microservice.searchservice.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	public CarDTO findCar(Long id) {
		
		Car car = repository.findById(id).orElse(null);
		
		if (car == null) 
			throw new NoSuchElementException();
		
		return new CarDTO(car);
	}
}
