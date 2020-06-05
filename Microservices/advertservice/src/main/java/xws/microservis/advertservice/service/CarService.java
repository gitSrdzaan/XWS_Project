package xws.microservis.advertservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.exception.CarNotFoundException;
import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.repository.CarRepository;

@Service
@Transactional
public class CarService {

	@Autowired
	CarRepository carRepository;
	
	public Car findById(Long id){
		
		Optional<Car> car = carRepository.findById(id);
		
		if(car.isPresent()) {
			
			return car.get();
		}else {
			throw new CarNotFoundException(id);
		}
	}
}
