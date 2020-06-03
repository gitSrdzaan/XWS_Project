package xws.microservis.rentservice.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.dto.CarDTO;
import xws.microservis.rentservice.model.Car;
import xws.microservis.rentservice.repository.CarRepository;

@Service
public class CarService  {

	@Autowired 
	private CarRepository repository;
	
	//pronalazenj auta
	public CarDTO findCar(Long id) {
		Car c = repository.findById(id).orElse(null);
		
		if(c  == null)
			throw new NoSuchElementException();
		
		return new CarDTO(c);
	}
	
	
	
}
