package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.Car;
import xml.team.rentacar.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	public boolean addCar(Car car) throws Exception {
		
		try {
			repository.save(car);
		}
		catch(Exception e) {
			throw new Exception("Neuspjesan pokusaj uspisivanja auta u bazu");
		}
		
		return true;
	}

	public List<Car> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = (ArrayList<Car>) repository.findAll();
		if(cars == null) {
			return null;
		}
		
		return cars;
	}
}
