package xws.microservice.searchservice.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.model.*;
import xws.microservice.searchservice.repository.CarFuelRepository;
import xws.microservice.searchservice.repository.CarRepository;
import xws.microservice.searchservice.repository.OwnerRepository;
import xws.microservice.searchservice.repository.TransmissionRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	@Autowired
	private TransmissionRepository transmissionRepository;

	@Autowired
	private CarFuelRepository carFuelRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	
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


    public void addCar(CarDTO carDTO) throws Exception {
		Car car = repository.findById(carDTO.getId()).orElse(new Car());

		dto2Car(carDTO, car);

		Firm firm = ownerRepository.findOwnerFirm(carDTO.getOwner_id());

		if (firm != null) {
			car.setOwner(firm);
		} else {
			User user = ownerRepository.findOwnerUser(carDTO.getOwner_id());
			car.setOwner(user);
		}

		repository.save(car);
	}


    private void dto2Car(CarDTO carDTO,Car car) {
		//car.setId(carDTO.getId());
		car.setCarClass(carDTO.getCarClass());
		car.setCarComment(carDTO.getCarComment());
		car.setCarFuel(carFuelRepository.findById(carDTO.getCarFuel()).orElse(null));
		car.setTransmission(transmissionRepository.findById(carDTO.getTransmission()).orElse(null));
		car.setCarMark(carDTO.getCarMark());
		car.setCarModel(carDTO.getCarModel());
		car.setCarGrade(carDTO.getCarGrade());
		car.setCarMileage(carDTO.getCarMileage());
		car.setMaxAllowedMileage(carDTO.getMaxAllowedMileage());
		car.setKidsSeats(carDTO.getKidsSeats());
		car.setCarRegistration(carDTO.getCarRegistration());
	}

	public HashSet<String> getAllCarRegs() {

		ArrayList<Car> cars = (ArrayList<Car>) repository.findAll();

		HashSet<String> registrations = new HashSet<>();

		for(Car car : cars){
			registrations.add(car.getCarRegistration());
		}
		return registrations;

	}
}
