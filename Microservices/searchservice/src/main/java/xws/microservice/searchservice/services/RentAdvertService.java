package xws.microservice.searchservice.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.model.RentAdvert;
import xws.microservice.searchservice.repository.RentAdvertRepository;

@Service
public class RentAdvertService {

	@Autowired
	private RentAdvertRepository repository;
	
	public RentAdvertDTO findRentAdvert(Long id) {
		
		RentAdvert rentAdvert = repository.findById(id).orElse(null);
		
		if(rentAdvert == null)
			throw new NoSuchElementException();
		
		return new RentAdvertDTO(rentAdvert);
		
	}
	
}
