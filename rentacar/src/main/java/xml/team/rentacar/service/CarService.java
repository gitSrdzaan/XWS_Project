package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.CarMark;
import xml.team.rentacar.repository.CarClassRepository;
import xml.team.rentacar.repository.CarMarkRepository;
import xml.team.rentacar.repository.CarModelRepository;
import xml.team.rentacar.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	@Autowired
	private CarMarkRepository markRepository;
	
	@Autowired
	private CarModelRepository modelRepository;
	
	@Autowired
	private CarClassRepository classRepository;
	
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

	public ArrayList<CarMark> findMark(String carMark) {
		// TODO Auto-generated method stub
		
		ArrayList<CarMark> markList = (ArrayList<CarMark>) markRepository.findByMark(carMark);
		if(markList == null) {
			return null;
		}
		
		return null;
	}
}
