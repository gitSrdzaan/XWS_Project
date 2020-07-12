package xws.microservice.searchservice.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.Transmission;
import xws.microservice.searchservice.repository.CarFuelRepository;
import xws.microservice.searchservice.repository.CarRepository;
import xws.microservice.searchservice.repository.TransmissionRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	@Autowired
	private TransmissionRepository transmissionRepository;

	@Autowired
	private CarFuelRepository carFuelRepository;
	
	public CarDTO findCar(Long id) {
		
		Car car = repository.findById(id).orElse(null);
		
		if (car == null) 
			throw new NoSuchElementException();
		
		return new CarDTO(car);
	}

    public ArrayList<Car> getAll() {
		return (ArrayList<Car>) repository.findAll();
    }


	public HashSet<String> getAllTransmission() {
		return (HashSet<String>) transmissionRepository.findAllTransmission();
	}

	public HashSet<String> getAllCarFuel() {

		return (HashSet<String>) carFuelRepository.findAllCarFuel();
	}

    public void addCar(Car car) throws Exception {
		try {
			repository.save(car);
		}
		catch(Exception e) {
			throw new Exception("Neuspjesan pokusaj uspisivanja auta u bazu");
		}
    }
}
