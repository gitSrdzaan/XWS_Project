package xws.microservis.advertservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.exception.CarNotFoundException;
import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.model.User;
import xws.microservis.advertservice.repository.CarRepository;
import xws.microservis.advertservice.repository.UserRepository;

@Service
@Transactional
public class CarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	UserRepository userRepository;
	
	public Car findById(Long id){
		
		Optional<Car> car = carRepository.findById(id);
		
		if(car.isPresent()) {
			
			return car.get();
		}else {
			throw new CarNotFoundException(id);
		}
	}

	public void saveNewCar(Car car) throws Exception {
		User user  = userRepository.findById(car.getUser().getId()).orElse(null);
		if(user == null){
			throw new Exception("Korisnik ne postoji");
		}
		car.setUser(user);
		try {
			carRepository.save(car);
		}
		catch (Exception e){
			e.printStackTrace();
			throw new Exception("Greska u pokusaju uspisa automobila");
		}

	}
}
