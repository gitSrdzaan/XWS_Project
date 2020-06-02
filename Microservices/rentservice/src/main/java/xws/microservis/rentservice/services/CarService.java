package xws.microservis.rentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.repository.CarRepository;

@Service
public class CarService  {

	@Autowired 
	private CarRepository repository;
	
	
}
