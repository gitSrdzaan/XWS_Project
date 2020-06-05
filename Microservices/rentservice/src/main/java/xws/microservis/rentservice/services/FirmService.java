package xws.microservis.rentservice.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.dto.CarDTO;
import xws.microservis.rentservice.dto.FirmDTO;
import xws.microservis.rentservice.model.Car;
import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.repository.CarRepository;
import xws.microservis.rentservice.repository.FirmRepository;

@Service
public class FirmService {
	@Autowired
	private FirmRepository repository;
	@Autowired
	private CarRepository carRepository;
	
	
	//pronalazenje auta
	public FirmDTO findFirm(Long id) {
		Firm f = repository.findById(id).orElse(null);
		
		if(f == null) {
			throw new NoSuchElementException();
		}
		return new FirmDTO(f);
		
	}
	
	public FirmDTO findFirmByCar(Car car) throws NoSuchElementException {
		ArrayList<Firm> firmList = (ArrayList<Firm>)repository.findAll();
		
		
		if(car == null) {
			throw new NoSuchElementException("Firma nema auto");
		}
		
		for(Firm f : firmList) {
			if(f.getFirmCars().contains(car)) {
				return new FirmDTO(f);
			}
		}
		return null;
	}
}
